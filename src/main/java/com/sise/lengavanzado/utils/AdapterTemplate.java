package com.sise.lengavanzado.utils;

public interface AdapterTemplate <TEntity, TInsert, TUpdate>{
    public TEntity insertToEntity(TInsert insert);
    public TEntity updateToEntity(TUpdate update);
}
