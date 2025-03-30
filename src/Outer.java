class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirDetalhes(){
        System.out.println("Marca: " + marca +", Modelo: "+ modelo+", Ano: "+ ano);
    }
}

class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        super(marca, modelo, ano);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("Marca: " + marca +", Modelo: "+ modelo+", Ano: "+ ano +", Número de portas: "+numeroDePortas);
    }
}

class Moto extends Veiculo {
    boolean temSideCar;

    public Moto(String marca, String modelo, int ano, boolean temSideCar) {
        super(marca, modelo, ano);
        this.temSideCar = temSideCar;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("Marca: " + marca +", Modelo: "+ modelo+", Ano: "+ ano +", Tem sidecar: "+(temSideCar ? "Sim" : "Não"));
    }
}

public class Outer {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Volkswagen", "Gol", 2020, 4);
        System.out.println("Detalhes do Carro:");
        carro1.exibirDetalhes();

        System.out.println("-------------------");
        //Opa teste de comment
        Moto moto1 = new Moto("Honda", "CB 500", 2021, false);
        System.out.println("Detalhes da Moto:");
        moto1.exibirDetalhes();
        
    }
}