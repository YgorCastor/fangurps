package me.ycastor.fangurps.fantasygrounds.library.metadata;

import cyclops.data.Vector;
import lombok.extern.slf4j.Slf4j;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.CategoryName;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.Clazz;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.Entry;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.EntryName;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.Library;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.LibraryLink;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.LibraryMetadata;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.LibraryName;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.RecordName;
import me.ycastor.fangurps.fantasygrounds.library.metadata.models.RecordType;
import me.ycastor.fangurps.fantasygrounds.skills.FGModType;
import me.ycastor.fangurps.shared.mapper.DynamicTagWrapper;

@Slf4j
public class LibraryMetadataBuilder {

    public static Library build(FGModType modType, String libraryName) {
        log.info("Building Fantasy Grounds metadata for Library Type: {}, Library Name: {},  Library Entry: {}, Record Type: {}",
                 modType.getLibraryType(),
                 libraryName,
                 modType.getLibraryEntry(),
                 modType.getRecordType()
        );
        var libraryLink = buildLibraryLink();
        var entry = buildEntry(modType.getLibraryEntry(), modType.getRecordType(), libraryLink);
        var libraryMetadata = DynamicTagWrapper.<LibraryMetadata>builder()
                .tagName(modType.getLibraryType())
                .value(buildLibraryMetadata(libraryName, entry))
                .build();
        return Library.builder().libraryMetadata(libraryMetadata).build();
    }

    @SuppressWarnings("unchecked")
    private static LibraryMetadata buildLibraryMetadata(String libraryName, Entry entry) {
        var wrappedEntry = DynamicTagWrapper.<Entry>builder().tagName(entry.getRecordType().getValue()).value(entry).build();
        return LibraryMetadata.builder()
                              .categoryName(CategoryName.builder().build())
                              .entries(Vector.of(wrappedEntry))
                              .name(LibraryName.builder().value(libraryName).build())
                              .isStatic("true")
                              .build();
    }

    private static Entry buildEntry(String libraryEntry, String recordType, LibraryLink libraryLink) {
        return Entry.builder()
                    .libraryLink(libraryLink)
                    .name(EntryName.builder().value(libraryEntry).build())
                    .recordType(RecordType.builder().value(recordType).build())
                    .build();
    }

    private static LibraryLink buildLibraryLink() {
        return LibraryLink.builder()
                          .clazz(Clazz.builder().value("reference_list").build())
                          .recordName(RecordName.builder().value("..").build())
                          .build();
    }

}
