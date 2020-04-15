package me.ycastor.fangurps.fantasygrounds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.ycastor.fangurps.AppConfig;
import me.ycastor.fangurps.fantasygrounds.library.metadata.FGLibrarySerializer;
import me.ycastor.fangurps.fantasygrounds.library.metadata.LibraryMetadataBuilder;
import me.ycastor.fangurps.fantasygrounds.skills.FGModType;
import me.ycastor.fangurps.fantasygrounds.library.metadata.FGLibraryRootMapper;
import me.ycastor.fangurps.fixtures.FantasyGroundsFixtures;
import me.ycastor.fangurps.utils.ResourceStringReader;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Story: Serializes a FGMod to a valid FantasyGrounds XML")
class FGLibrarySerializerTest {
    private final ResourceStringReader resourceStringReader = new ResourceStringReader();
    private FGLibrarySerializer modWriter;

    @BeforeEach
    void setUp() {
        var rootMapper = new FGLibraryRootMapper(new AppConfig().xmlMapper());
        modWriter = new FGLibrarySerializer(rootMapper);
    }

    @Test
    @DisplayName("Scenario: Serialize the Library successfully")
    public void writeMod_Success() {
        // given
        var fgAbility = FantasyGroundsFixtures.fgAbility();
        var metadata = LibraryMetadataBuilder.build(FGModType.ABILITY, "Test Skill Set");
        var expected = resourceStringReader.read("/fg/skill_simple.xml");

        // when
        var result = modWriter.toXml(fgAbility, FGModType.ABILITY.getRecordType(), metadata);

        // Assertions
        assertThat(result.get().orElse(null)).isEqualToIgnoringWhitespace(expected);
    }

}