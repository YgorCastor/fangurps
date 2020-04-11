package me.ycastor.fangurps.fantasygrounds.metadata;

import java.util.Vector;

import me.ycastor.fangurps.shared.mapper.DynamicContainer;

public abstract class LibraryMetadata<T> extends DynamicContainer<T> {
    private CategoryName categoryName;
    private LibraryName name;
    private Vector<Entry> entries;
}
