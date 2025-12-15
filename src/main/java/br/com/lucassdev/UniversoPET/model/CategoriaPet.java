package br.com.lucassdev.UniversoPET.model;

public enum CategoriaPet {
    CACHORRO ("Cachorro"), 
    GATO ("Gato"), 
    OUTRO ("Outro");

    private String categoriaPet;

    CategoriaPet(String categoriaPet) {
        this.categoriaPet = categoriaPet;
    }

    public String getCategoriaPet() {
        return categoriaPet;
    }
}
