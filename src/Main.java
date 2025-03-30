import aula01.Cliente;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cliente cliente01;

        cliente01 = new Cliente(1, "Iguinho", "ND", "ND");
        cliente01.setEmail("generico@generico.com");
        cliente01.setTelefone("12345678901");

        System.out.println(cliente01.toString());
        System.out.println("----");
    }

}