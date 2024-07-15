package com.alura.literalura.services;

public abstract class DatosConverter {
    public abstract <T> T JsonToClass(String json, Class<T> clase);
}
