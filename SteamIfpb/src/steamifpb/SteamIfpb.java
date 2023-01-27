package steamifpb;

import dominio.Distribuidora;
import java.sql.SQLException;
import java.util.Scanner;
import dominio.Game;
import negocio.GameNegocio;
import negocio.DistribuidoraNegocio;

public class SteamIfpb {

    private static DistribuidoraNegocio distribuidoraNegocio = new DistribuidoraNegocio();
    private static GameNegocio gameNegocio = new GameNegocio();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Distribuidora distribuidora = null;
        Game game = null;
                
        String nomeD, site, nomeG, genero;
        int codigoD, codigoG, codigoDist;
        double preco;

        int opcaoGlobal;
        do {
            System.out.println("0 - Encerrar aplicação \n1 - Aba de Distribuidoras \n2 - Aba de Jogos");
            opcaoGlobal = sc.nextInt();
            if (opcaoGlobal == 0) {
                System.out.println("Aplicação encerrada.");
            }
            if (opcaoGlobal == 1) {

                int opcaoD;
                System.out.println("0 - Encerrar programa \n1 - Listar distribuidoras e games"
                        + "\n2 - Inserir distribuidora \n3 - Alterar distribuidora \n4 - Excluir distribuidora");
                System.out.println("/////////////////////////");

                System.out.println("Digite a opção: ");
                opcaoD = sc.nextInt();

                switch (opcaoD) {
                    case 0:
                        System.out.println("Programa encerrado");
                        break;

                    case 1:
                        listarDistribuidoras();
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("Digite o nome da distribuidora: ");
                        nomeD = sc.next();
                        System.out.println("Digite o codigo da distrribuidora: ");
                        codigoD = sc.nextInt();
                        System.out.println("Digite o site da distribuidora: ");
                        site = sc.next();

                        distribuidora = new Distribuidora(nomeD, codigoD, site);
                        inserirDistribuidora(distribuidora);

                        break;

                    case 3:
                        System.out.println("Digite o nome da distribuidora: ");
                        nomeD = sc.next();
                        System.out.println("Digite o site da distribuidora: ");
                        site = sc.next();
                        System.out.println("Digite o codigo da distribuidora que deseja modificar: ");
                        codigoD = sc.nextInt();
                        distribuidora = new Distribuidora(nomeD, codigoD, site);
                        alterarPorCodigo(distribuidora);
                        break;

                    case 4:
                        System.out.println("Digite o codigo da distribuidora que deseja excluir");
                        codigoD = sc.nextInt();
                        excluirPorCodigo(codigoD);
                        break;
                    default:
                        System.out.println("Opção invalida");
                }
            }
            if (opcaoGlobal == 2) {

                int opcaoG;
                System.out.println("0 - Encerrar programa \n1 - Listar games"
                        + "\n2 - Inserir game \n3 - Alterar game \n4 - Excluir game");
                System.out.println("/////////////////////////");
                opcaoG = sc.nextInt();

                switch (opcaoG) {
                    case 0:
                        System.out.println("Programa encerrado");
                        break;

                    case 1:
                        listarGames();
                        System.out.println("");
                        break;
                        
                    case 2:
                        System.out.println("Digite o nome do jogo: ");
                        nomeG = sc.next();
                        System.out.println("Informe o preço do jogo:");
                        preco = sc.nextDouble();
                        System.out.println("Informe o gênero do jogo: ");
                        genero = sc.next();
                        System.out.println("Digite o código do jogo: ");
                        codigoG = sc.nextInt();
                        System.out.println("Informe o código da distribuidora do jogo: ");
                        codigoDist = sc.nextInt();

                        game = new Game(nomeG, preco, genero, codigoG, codigoDist);
                        inserirGame(game);
                        break;

                    case 3:
                        System.out.println("Digite o nome do jogo: ");
                        nomeG = sc.next();
                        System.out.println("Informe o preço do jogo:");
                        preco = sc.nextDouble();
                        System.out.println("Informe o gênero do jogo: ");
                        genero = sc.next();
                        System.out.println("Informe o código da distribuidora do jogo: ");
                        codigoDist = sc.nextInt();
                        System.out.println("Digite o codigo do game que deseja modificar: ");
                        codigoG = sc.nextInt();
                        game = new Game(nomeG, preco, genero, codigoG, codigoDist);
                        alterarPorCodigoG(game);
                        break;

                    case 4:
                        System.out.println("Digit22e o codigo do jogo que deseja excluir: ");
                        codigoG = sc.nextInt();
                        excluirPorCodigoG(codigoG);
                        break;
                    default:
                        System.out.println("Opção invalida.");
                }

            }

        } while (opcaoGlobal != 0);

        sc.close();

    } //separação do main:

    public static void listarDistribuidoras() {
        System.out.println("Listar todas as distribuidoras: ");
        try {
            for (Distribuidora distribuidora : distribuidoraNegocio.listarTodos()) {
                System.out.println(distribuidora);

            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar distribuidoras.");
        }
    }

    public static void inserirDistribuidora(Distribuidora distribuidora) throws Exception {

        try {
            distribuidoraNegocio.inserirDistribuidora(distribuidora);
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tupla.");

        }
    }

    public static void alterarPorCodigo(Distribuidora distribuidora) throws Exception {
        try {
            distribuidoraNegocio.alterarPorCodigo(distribuidora);
            System.out.println("Alterado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao alterar.");
        }

    }

    public static void excluirPorCodigo(int codigoD) throws Exception {
        try {
            distribuidoraNegocio.excluirPorCodigo(codigoD);
            System.out.println("Excluído com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir.");

        }
    }

    public static void listarGames() {
        System.out.println("Listar todos os jogos: ");
        try {
            for (Game game : gameNegocio.listarJogos()) {
                System.out.println(game);

            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar jogos.");
        }
    }

    public static void inserirGame(Game game) throws Exception {
        try {
            gameNegocio.inserirGame(game);
            System.out.println("Inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir tupla.");

        }
    }

    public static void alterarPorCodigoG(Game game) throws Exception {
        try {
            gameNegocio.alterarPorCodigo(game);
            System.out.println("Alterado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao alterar.");
        }

    }

    public static void excluirPorCodigoG(int codigoG) throws Exception {
        try {
            gameNegocio.excluirPorCodigo(codigoG);
            System.out.println("Excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir.");

        }
    }
}
