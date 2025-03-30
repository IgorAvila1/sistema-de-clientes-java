package Mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaClientes {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        while(true){
            try {
                System.out.println("*Sistema de gerenciamento de clientes*\n");
                System.out.println("Menu Principal");
                System.out.println("1 - Cadastro de Cliente");
                System.out.println("2 - Listagem de Clientes");
                System.out.println("3 - Atualização de Dados de Clientes");
                System.out.println("4 - Remoção de Clientes");
                System.out.println("5 - Busca de Clientes");
                System.out.println("6 - Fechar sistema");
                System.out.println("Selecione a opção desejada.\n");
                int navigation = in.nextInt();
                in.nextLine();
                if (navigation == 6) {
                    System.out.println("Deseja fechar o sistema de gerenciamento de clientes? (S/N)");
                    char confirmar = in.nextLine().toUpperCase().charAt(0);
                    if (confirmar == 'S') {
                        System.out.println("Até a próxima!");
                        break;
                    }
                }
                System.out.println("\n\n");

                switch(navigation) {
                    case 1:
                        while(true) {
                            System.out.println("*Cadastro de Cliente*");
                            System.out.println("Insira o nome do cliente");
                            String nome = in.nextLine();
                            System.out.println("Insira o e-mail do cliente");
                            String email = in.nextLine();
                            System.out.println("Insira o telefone do cliente");
                            String telefone = in.nextLine();

                            System.out.println("Dados do cliente:");
                            System.out.printf("Nome: \"%s\"; E-mail: \"%s\"; Telefone: \"%s\"\n", nome, email, telefone);
                            System.out.println("Deseja cofirmar o cadastro do cliente? (S/N)");
                            char confirmar = in.nextLine().toUpperCase().charAt(0);
                            if (confirmar == 'S') {
                                clientes.add(new Cliente(nome, email, telefone));
                                System.out.println("Cadastro realizado com sucesso!");
                            } else {
                                System.out.println("Cadastro cancelado com sucesso!");
                            }
                            System.out.println("Deseja adicionar outro cliente? (S/N)\"");
                            confirmar = in.nextLine().toUpperCase().charAt(0);
                            if (confirmar != 'S') {
                                System.out.println("\n");
                                System.out.println("\n");
                                break;
                            }
                            System.out.println("\n");
                            System.out.println("\n");
                        }
                        break;
                    case 2:
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            System.out.println("*Listagem clientes*");
                            for (Cliente cliente : clientes) {
                                System.out.println(cliente);
                            }
                        }
                        System.out.println("Digite qualquer valor para voltar ao menu");
                        in.nextLine();
                        System.out.println("\n");
                        System.out.println("\n");
                        break;
                    case 3:
                        while(true){
                            System.out.println("*Atualização de Dados de Clientes*");
                            System.out.println(" Informe o Id do cliente:");
                            int idCliente = in.nextInt();
                            in.nextLine();
                            Cliente clienteOld = getClienteById(idCliente);
                            if (clienteOld != null) {
                                System.out.println("Dados atuais: "+clienteOld.toString());

                                System.out.print("Novo nome (deixe vazio para não alterar): ");
                                String nome = in.nextLine();
                                if (!nome.isEmpty()) clienteOld.setNome(nome);

                                System.out.print("Novo e-mail (deixe vazio para não alterar): ");
                                String email = in.nextLine();
                                if (!email.isEmpty()) clienteOld.setEmail(email);

                                System.out.print("Novo telefone (deixe vazio para não alterar): ");
                                String telefone = in.nextLine();
                                if (!telefone.isEmpty()) clienteOld.setTelefone(telefone);

                                System.out.printf("\nEdição do cliente Id: %d realizada com sucesso!\n", idCliente);
                                System.out.printf("Nome: \"%s\"; E-mail: \"%s\"; Telefone: \"%s\"\n", clienteOld.getNome(), clienteOld.getEmail(), clienteOld.getTelefone());

                                System.out.println("Deseja editar outro cliente? (S/N)");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                                System.out.println("\n");
                                System.out.println("\n");
                            } else {
                                System.out.printf("\nCliente de Id: %d não encontrado!\n", idCliente);
                                System.out.println("Deseja tentar novamente? (S/N)");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        while(true){
                            System.out.println("*Remoção de Clientes*");
                            System.out.println(" Informe o Id do cliente:");
                            int idCliente = in.nextInt();
                            in.nextLine();
                            Cliente clienteOld = getClienteById(idCliente);
                            if (clienteOld != null) {
                                System.out.println("Dados atuais: " + clienteOld.toString());
                                System.out.println("Confirmar a remoção do cliente Id: " +idCliente+" ? (S/N)");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar == 'S') {
                                    clientes.remove(clienteOld);
                                    System.out.println("Remoção realizada com sucesso!");
                                } else {
                                    System.out.println("Remoção cancelada!");
                                }
                                System.out.println("Deseja remover outro cliente? (S/N)");
                                confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                                System.out.println("\n");
                                System.out.println("\n");
                            } else {
                                System.out.printf("\nCliente de Id: %d não encontrado!\n", idCliente);
                                System.out.println("Deseja tentar novamente? (S/N)\"");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                            }
                        }

                        break;
                    case 5:
                        while(true){
                            System.out.println("*Busca de Clientes*");
                            System.out.println(" Informe o Id do cliente:");
                            int idCliente = in.nextInt();
                            in.nextLine();
                            Cliente cliente = getClienteById(idCliente);
                            if (cliente != null) {
                                System.out.println(cliente.toString());
                                System.out.println("Deseja buscar outro cliente? (S/N)");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                                System.out.println("\n");
                                System.out.println("\n");
                            } else {
                                System.out.printf("\nCliente de Id: %d não encontrado!\n", idCliente);
                                System.out.println("Deseja tentar novamente? (S/N)");
                                char confirmar = in.nextLine().toUpperCase().charAt(0);
                                if (confirmar != 'S') {
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    break;
                                }
                            }
                        }


                        break;
                    default:
                        System.out.println("Índice ("+ navigation +") não encontrado, ou inválido. Tente novamente!");
                }
                //} catch (Exception e) {

            }catch (Exception e) {
                System.out.println("Erro ao executar a ação. Erro: "+e.getMessage());
                System.out.println("Tente novamente!");
                System.out.flush();
                in.nextLine();
            }
        }

        in.close();
    }

    private static Cliente getClienteById(int id) {
        for (Cliente cliente :clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}

class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    private static int idNumber = 1;

    public Cliente(String nome, String email, String telefone) {
        this.id = idNumber++;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
