import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static EditorasFavoritas editorasFavoritasGeral = new EditorasFavoritas();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        boolean loginMenu = true;
        while (loginMenu) {
            int jaLi;
            int naoLi;
            float valorColecao;
            printLoginMenu();
            int loginOption = input.nextInt();
            input.nextLine();
            switch (loginOption) {
                case 1:
                    if (usuarios.size() > 0) {
                        System.out.print("Username:");
                        String usernameLogin = input.nextLine();
                        System.out.print("Password:");
                        String passwordLogin = input.nextLine();
                        System.out.println();

                        boolean success = false;

                        for (int indexLogin = 0; indexLogin < usuarios.size(); indexLogin++) {
                            if (usernameLogin.contentEquals(usuarios.get(indexLogin).getNome()) && passwordLogin.contentEquals(usuarios.get(indexLogin).getSenha())) {
                                success = true;
                                Usuario usuario = usuarios.get(indexLogin);
                                System.out.println("Bem-vindo " + usuario.getNome() + ".");

                                if (usuario.getNome().equals("Rodrigo")) {
                                    Role admin = new Role().named("Administrador");
                                    usuario.named("Rodrigo").is(admin);

                                } else {
                                    Role visitante = new Role().named("Visitante");
                                    usuario.named(usernameLogin).is(visitante);
                                }

                                ExecutorComandos exec = new ExecutorComandos();

                                boolean mainMenu = true;
                                while (mainMenu) {
                                    printMainMenu();
                                    int mainOption = input.nextInt();
                                    input.nextLine();
                                    switch (mainOption) {
                                        case 1:
                                            boolean createMenu = true;
                                            while (createMenu) {
                                                System.out.println("Cria????o");
                                                System.out.println("-[1] - Cria????o R??pida");
                                                System.out.println("-[2] - Cria????o Completa");
                                                int createOption = input.nextInt();
                                                input.nextLine();
                                                if (createOption == 1) {

                                                    System.out.println("Nome:");
                                                    String nome = input.nextLine();

                                                    System.out.println("Pre??o pago Ex R$55.0:");
                                                    float preco = input.nextFloat();

                                                    valorColecao = usuario.getValorColecao();
                                                    valorColecao += preco;
                                                    usuario.setValorColecao(valorColecao);
                                                    input.nextLine();

                                                    System.out.println("Status:");
                                                    String status = "";
                                                    boolean statusMenu = true;
                                                    while (statusMenu) {
                                                        System.out.println("-[1] - J?? li");
                                                        System.out.println("-[2] - Lendo");
                                                        System.out.println("-[3] - N??o li");
                                                        int statusInput = input.nextInt();
                                                        if (statusInput == 1) {
                                                            jaLi = usuario.getNumLi();
                                                            jaLi++;
                                                            usuario.setNumLi(jaLi);
                                                            status = "J?? li";
                                                            statusMenu = false;
                                                        } else if (statusInput == 2) {
                                                            status = "Lendo";
                                                            statusMenu = false;
                                                        } else if (statusInput == 3) {
                                                            naoLi = usuario.getNumNaoLi();
                                                            naoLi++;
                                                            usuario.setNumNaoLi(naoLi);
                                                            status = "N??o li";
                                                            statusMenu = false;
                                                        } else {
                                                            System.out.println("Op????o invalida!");
                                                        }
                                                    }
                                                    Quadrinho quadrinho = Quadrinho.criaSimples(nome, preco, status);
                                                    usuario.getQuadrinhos().add(quadrinho);
                                                    createMenu = false;
                                                } else if (createOption == 2) {

                                                    System.out.println("Nome:");
                                                    String nome = input.nextLine();

                                                    System.out.println("Estado:");
                                                    String estado = "";
                                                    boolean estadoMenu = true;
                                                    while (estadoMenu) {
                                                        System.out.println("-[1] - Excelente");
                                                        System.out.println("-[2] - Bom");
                                                        System.out.println("-[3] - P??ssimo");
                                                        int estadoInput = input.nextInt();
                                                        if (estadoInput == 1) {
                                                            estado = "Excelente";
                                                            estadoMenu = false;
                                                        } else if (estadoInput == 2) {
                                                            estado = "Bom";
                                                            estadoMenu = false;
                                                        } else if (estadoInput == 3) {
                                                            estado = "P??ssimo";
                                                            estadoMenu = false;
                                                        } else {
                                                            System.out.println("Op????o invalida!");
                                                        }
                                                    }
                                                    System.out.println("Pre??o pago Ex R$55.0:");
                                                    float preco = input.nextFloat();

                                                    valorColecao = usuario.getValorColecao();
                                                    valorColecao += preco;
                                                    usuario.setValorColecao(valorColecao);
                                                    input.nextLine();

                                                    System.out.println("Entrou na cole????o em Ex.30/12/2022: ");
                                                    String dataAquisicao = input.nextLine();

                                                    System.out.println("Status:");
                                                    String status = "";
                                                    boolean statusMenu = true;
                                                    while (statusMenu) {
                                                        System.out.println("-[1] - J?? li");
                                                        System.out.println("-[2] - Lendo");
                                                        System.out.println("-[3] - N??o li");
                                                        int statusInput = input.nextInt();
                                                        if (statusInput == 1) {
                                                            jaLi = usuario.getNumLi();
                                                            jaLi++;
                                                            usuario.setNumLi(jaLi);
                                                            status = "J?? li";
                                                            statusMenu = false;
                                                        } else if (statusInput == 2) {
                                                            status = "Lendo";
                                                            statusMenu = false;
                                                        } else if (statusInput == 3) {
                                                            naoLi = usuario.getNumNaoLi();
                                                            naoLi++;
                                                            usuario.setNumNaoLi(naoLi);
                                                            status = "N??o li";
                                                            statusMenu = false;
                                                        } else {
                                                            System.out.println("Op????o invalida!");
                                                        }
                                                    }
                                                    boolean extraMenu = true;
                                                    while (extraMenu) {
                                                        System.out.println("-[1] - Nota");
                                                        System.out.println("-[2] - Descri????o");
                                                        int extraOption = input.nextInt();
                                                        input.nextLine();
                                                        if (extraOption == 1) {
                                                            System.out.print("Nota:");
                                                            String nota = input.nextLine();

                                                            Quadrinho quadrinho = Quadrinho.criaNota(nome, estado, preco, dataAquisicao, status, nota);
                                                            usuario.getQuadrinhos().add(quadrinho);
                                                            extraMenu = false;
                                                        } else if (extraOption == 2) {
                                                            System.out.println("Descri????o:");
                                                            String descricao = input.nextLine();

                                                            Quadrinho quadrinho = Quadrinho.criaDescricao(nome, estado, preco, dataAquisicao, status, descricao);
                                                            usuario.getQuadrinhos().add(quadrinho);
                                                            extraMenu = false;
                                                        } else {
                                                            System.out.println("Op????o invalida!");
                                                        }
                                                    }
                                                    createMenu = false;
                                                } else {
                                                    System.out.println("Op????o invalida!");
                                                }
                                                break;
                                            }

                                            break;
                                        case 2:

                                            if (usuario.getQuadrinhos().size() < 1) {
                                                System.out.println("N??o h?? quadrinhos cadastrados");
                                            } else {
                                                for (int indexQuadrinhos = 0; indexQuadrinhos < usuario.getQuadrinhos().size(); indexQuadrinhos++) {
                                                    System.out.println(usuario.getQuadrinhos().get(indexQuadrinhos).getNome() + "  " + "ID:" + usuario.getQuadrinhos().get(indexQuadrinhos).getId());
                                                    System.out.println("Estado:" + usuario.getQuadrinhos().get(indexQuadrinhos).getEstado());
                                                    System.out.println("Pre??o:" + usuario.getQuadrinhos().get(indexQuadrinhos).getPreco());
                                                    System.out.println("Entrou na cole????o em:" + usuario.getQuadrinhos().get(indexQuadrinhos).getDataAquisicao());
                                                    System.out.println("Status:" + usuario.getQuadrinhos().get(indexQuadrinhos).getStatus());
                                                    System.out.println("Notas:" + usuario.getQuadrinhos().get(indexQuadrinhos).getNota());
                                                    System.out.println("Descri????o:" + usuario.getQuadrinhos().get(indexQuadrinhos).getDescricao());

                                                    if (usuario.getQuadrinhos().size() > 1) {
                                                        System.out.println();
                                                    }
                                                }
                                            }

                                            break;
                                        case 3:
                                            System.out.println(usuario.getNome() + "    " + "ID:" + usuario.getId() + "    " + usuario.getRole().getName());
                                            if (usuario.getQuadrinhos().size() < 1) {
                                                System.out.println();
                                                System.out.println("N??o h?? nenhum quadrinho cadastrado no momento!");
                                            } else {
                                                System.out.println();
                                                System.out.println("J?? li:" + usuario.getNumLi());
                                                System.out.println("N??o li:" + usuario.getNumNaoLi());
                                            }
                                            System.out.println("Valor da cole????o:" + usuario.getValorColecao());

                                            break;
                                        case 4:

                                            boolean WishlistMenu = true;
                                            while (WishlistMenu) {

                                                if (usuario.getWishlist().getQuadrinhosWishlist().size() > 0) {
                                                    for (int index = 0; index < usuario.getWishlist().getQuadrinhosWishlist().size(); index++) {
                                                        System.out.println("Nome:" + usuario.getWishlist().getQuadrinhosWishlist().get(index).getNome());
                                                        System.out.println("Pre??o desejado:" + usuario.getWishlist().getQuadrinhosWishlist().get(index).getPreco());
                                                        System.out.println();
                                                    }
                                                } else {
                                                    System.out.println("Sua lista de desejos est?? vazia!");
                                                    System.out.println();
                                                }

                                                System.out.println("-[1] - Adicionar");
                                                System.out.println("-[2] - Remover");

                                                int WishlistOption = input.nextInt();
                                                input.nextLine();
                                                if (WishlistOption == 1) {

                                                    System.out.print("Nome:");
                                                    String nomeQuadrinhoWishlist = input.nextLine();

                                                    System.out.print("Pre??o que deseja pagar:");
                                                    float precoQuadrinhoWishlist = input.nextFloat();

                                                    QuadrinhoWishlist quadrinhoWishlist = new QuadrinhoWishlist(nomeQuadrinhoWishlist, precoQuadrinhoWishlist);

                                                    usuario.setWishlist(exec.fazer(new InserirQuadrinho(usuario.getWishlist(), quadrinhoWishlist)));

                                                    WishlistMenu = false;

                                                } else if (WishlistOption == 2) {

                                                    usuario.setWishlist(exec.desfazer());

                                                    WishlistMenu = false;

                                                } else {
                                                    System.out.println("Op????o invalida!");
                                                }

                                            }
                                            break;

                                        case 5:

                                            ProdutoFisico demolidorAQDMurdock = new ProdutoFisico(70, 1000, 10);
                                            ProdutoDigital demolidorAQDMurdockDigital = new ProdutoDigital(40, 10);

                                            ProdutoFisico thorOCDDeuses = new ProdutoFisico(90, 1000, 10);
                                            ProdutoDigital thorOCDDeusesDigital = new ProdutoDigital(40, 10);

                                            ProdutoFisico watchmenEDefinitiva = new ProdutoFisico(140, 1000, 10);
                                            ProdutoDigital watchmenEDefinitivaDigital = new ProdutoDigital(90, 10);

                                            ProdutoFisico maus = new ProdutoFisico(30, 1000, 10);
                                            ProdutoDigital mausDigital = new ProdutoDigital(15, 10);

                                            System.out.println("Quadrinhos dispon??veis para compra");
                                            System.out.println("Pre??os sem tarifas!");
                                            System.out.println();
                                            System.out.println("Demolidor: A Queda de Murdock");
                                            System.out.println("Capa dura:" + demolidorAQDMurdock.getPreco());
                                            System.out.println("Kindle:" + demolidorAQDMurdockDigital.getPreco());
                                            System.out.println();
                                            System.out.println("Thor: O Carniceiro dos Deuses");
                                            System.out.println("Capa dura:" + thorOCDDeuses.getPreco());
                                            System.out.println("Kindle:" + thorOCDDeusesDigital.getPreco());
                                            System.out.println();
                                            System.out.println("Watchmen: Edi????o Definitiva");
                                            System.out.println("Capa dura:" + watchmenEDefinitiva.getPreco());
                                            System.out.println("Kindle:" + watchmenEDefinitivaDigital.getPreco());
                                            System.out.println();
                                            System.out.println("Maus");
                                            System.out.println("Capa comum:" + maus.getPreco());
                                            System.out.println("Kindle:" + mausDigital.getPreco());
                                            System.out.println();

                                            boolean carrinhoMenu = true;
                                            while (carrinhoMenu) {
                                                System.out.println("Deseja comprar um exemplar:");
                                                System.out.println("-[1] - Sim");
                                                System.out.println("-[2] - N??o");
                                                int carrinhoOption = input.nextInt();
                                                if (carrinhoOption == 1) {
                                                    System.out.println("Escolha o exemplar desejado:");
                                                    boolean carrinhoMenuCompra = true;
                                                    while (carrinhoMenuCompra) {
                                                        System.out.println("-[1] - Demolidor: A Queda de Murdock");
                                                        System.out.println("-[2] - Thor: O Carniceiro dos Deuses");
                                                        System.out.println("-[3] - Watchmen: Edi????o Definitiva");
                                                        System.out.println("-[4] - Maus");
                                                        int carrinhoOptionCompra = input.nextInt();
                                                        if (carrinhoOptionCompra == 1) {
                                                            boolean carrinhoEdicaoMenu = true;
                                                            while (carrinhoEdicaoMenu) {
                                                                System.out.println("Edi????o:");
                                                                System.out.println("-[1] - Capa dura / Capa Comum");
                                                                System.out.println("-[2] - Kindle");
                                                                int carrinhoEdicaoOption = input.nextInt();
                                                                if (carrinhoEdicaoOption == 1) {
                                                                    usuario.getCarrinho().addProduto(demolidorAQDMurdock);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else if (carrinhoEdicaoOption == 2) {
                                                                    usuario.getCarrinho().addProduto(demolidorAQDMurdockDigital);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else {
                                                                    System.out.println("Edi????o n??o encontrada!");
                                                                }
                                                            }
                                                            carrinhoMenuCompra = false;
                                                        } else if (carrinhoOptionCompra == 2) {
                                                            boolean carrinhoEdicaoMenu = true;
                                                            while (carrinhoEdicaoMenu) {
                                                                System.out.println("Edi????o:");
                                                                System.out.println("-[1] - Capa dura / Capa Comum");
                                                                System.out.println("-[2] - Kindle");
                                                                int carrinhoEdicaoOption = input.nextInt();
                                                                if (carrinhoEdicaoOption == 1) {
                                                                    usuario.getCarrinho().addProduto(thorOCDDeuses);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else if (carrinhoEdicaoOption == 2) {
                                                                    usuario.getCarrinho().addProduto(thorOCDDeusesDigital);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else {
                                                                    System.out.println("Edi????o n??o encontrada!");
                                                                }
                                                            }
                                                            carrinhoMenuCompra = false;
                                                        } else if (carrinhoOptionCompra == 3) {
                                                            boolean carrinhoEdicaoMenu = true;
                                                            while (carrinhoEdicaoMenu) {
                                                                System.out.println("Edi????o:");
                                                                System.out.println("-[1] - Capa dura / Capa Comum");
                                                                System.out.println("-[2] - Kindle");
                                                                int carrinhoEdicaoOption = input.nextInt();
                                                                if (carrinhoEdicaoOption == 1) {
                                                                    usuario.getCarrinho().addProduto(watchmenEDefinitiva);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else if (carrinhoEdicaoOption == 2) {
                                                                    usuario.getCarrinho().addProduto(watchmenEDefinitivaDigital);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else {
                                                                    System.out.println("Edi????o n??o encontrada!");
                                                                }
                                                            }
                                                            carrinhoMenuCompra = false;
                                                        } else if (carrinhoOptionCompra == 4) {
                                                            boolean carrinhoEdicaoMenu = true;
                                                            while (carrinhoEdicaoMenu) {
                                                                System.out.println("Edi????o:");
                                                                System.out.println("-[1] - Capa dura / Capa Comum");
                                                                System.out.println("-[2] - Kindle");
                                                                int carrinhoEdicaoOption = input.nextInt();
                                                                if (carrinhoEdicaoOption == 1) {
                                                                    usuario.getCarrinho().addProduto(maus);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else if (carrinhoEdicaoOption == 2) {
                                                                    usuario.getCarrinho().addProduto(mausDigital);
                                                                    carrinhoEdicaoMenu = false;
                                                                } else {
                                                                    System.out.println("Edi????o n??o encontrada!");
                                                                }
                                                            }
                                                            carrinhoMenuCompra = false;
                                                        } else {
                                                            System.out.println("Quadrinho n??o encontrado!");
                                                        }
                                                    }
                                                    System.out.println("Carrinho");
                                                    System.out.println("Pre??o total:" + usuario.getCarrinho().getTotal());
                                                    System.out.println("Peso total:" + usuario.getCarrinho().getPeso());
                                                    carrinhoMenu = false;
                                                } else if (carrinhoOption == 2) {
                                                    carrinhoMenu = false;
                                                } else {
                                                    System.out.println("Op????o invalida!");
                                                }
                                            }
                                            break;
                                        case 6:
                                            System.out.println("Lan??amentos janeiro/2022");
                                            System.out.println();
                                            EditoraLancamento editoraLancamento = new EditoraLancamento();
                                            editoraLancamento.publicarEaglemoss();
                                            System.out.println();
                                            editoraLancamento.publicarPanini();
                                            System.out.println();
                                            editoraLancamento.publicarPipocaENanquim();
                                            System.out.println();
                                            break;
                                        case 7:
                                            if (usuario.getEditorasFavoritas().getEditora().isBlank()) {
                                                System.out.println("Lista vazia!");
                                            } else {
                                                System.out.println("Favoritas:" + usuario.getEditorasFavoritas().getEditora());
                                            }
                                            boolean editoraMenu = true;
                                            while (editoraMenu) {
                                                System.out.println("-[1] - Adicionar");
                                                System.out.println("-[0] - Sair");
                                                int editoraOption = input.nextInt();
                                                if (editoraOption == 1) {
                                                    input.nextLine();
                                                    boolean editoraFavoritaMenu = true;
                                                    while (editoraFavoritaMenu) {
                                                        System.out.println("Editoras parceiras");
                                                        System.out.println("-[1] - DarkSide Books");
                                                        System.out.println("-[2] - Eaglemoss");
                                                        System.out.println("-[3] - Panini");
                                                        System.out.println("-[4] - Pipoca & Nanquim");
                                                        System.out.println("-[5] - Dark Horse Comics");
                                                        System.out.println("Editora favorita:");
                                                        int editoraFavoritaOption = input.nextInt();
                                                        if (editoraFavoritaOption == 1) {
                                                            usuario.getEditorasFavoritas().add(EditoraFactory.get("darkside"));
                                                            editoraFavoritaMenu = false;
                                                        } else if (editoraFavoritaOption == 2) {
                                                            usuario.getEditorasFavoritas().add(EditoraFactory.get("eaglemoss"));
                                                            editoraFavoritaMenu = false;
                                                        } else if (editoraFavoritaOption == 3) {
                                                            usuario.getEditorasFavoritas().add(EditoraFactory.get("panini"));
                                                            editoraFavoritaMenu = false;
                                                        } else if (editoraFavoritaOption == 4) {
                                                            usuario.getEditorasFavoritas().add(EditoraFactory.get("pipocaENanquim"));
                                                            editoraFavoritaMenu = false;
                                                        } else if (editoraFavoritaOption == 5) {
                                                            usuario.getEditorasFavoritas().add(EditoraFactory.get("darkHorseComics"));
                                                            editoraFavoritaMenu = false;
                                                        } else {
                                                            System.out.println("Op????o invalida!");
                                                        }
                                                    }
                                                } else if (editoraOption == 0) {

                                                    editoraMenu = false;
                                                } else {
                                                    System.out.println("Op????o invalida!");
                                                }
                                            }
                                            editorasFavoritasGeral.add(usuario.getEditorasFavoritas());

                                            System.out.println("Todos os usu??rios:" + editorasFavoritasGeral.getEditora());

                                            break;
                                        case 0:
                                            mainMenu = false;
                                            break;
                                        default:
                                            System.out.println("Op????o invalida!");
                                            break;
                                    }
                                }
                            }
                        }
                        if (success == false) {
                            System.out.println("N??o foi poss??vel realizar o login, verifique as informa????es inseridas");
                        }
                    } else {
                        System.out.println("N??o existe nenhum usu??rio cadastrado no momento!");
                    }
                    break;

                case 2:
                    System.out.print("Username:");
                    String username = input.nextLine();
                    System.out.print("Password:");
                    String password = input.nextLine();

                    UsuarioDAOInterface usuarioDAO = new UsuarioDAODecorator();
                    try {
                        usuarioDAO.addUsuario(username, password);
                        Usuario usuario = new Usuario(username, password);
                        usuarios.add(usuario);
                        System.out.println("Usu??rio " + username + " cadastrado com sucesso!");
                    } catch (UsuarioException e) {
                        System.err.println("N??o consegui cadastrar o usu??rio " + username + ".");
                        System.err.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("At?? a pr??xima.");
                    loginMenu = false;
                    break;

                default:
                    System.out.println("Op????o invalida!");
                    break;

            }
        }

    }

    static void printLoginMenu() {
        System.out.println("---------------Bem-vindo---------------");
        System.out.println("-[1] - Fa??a seu login");
        System.out.println("-[2] - Cadastre-se");
        System.out.println("-[0] - Sair");
        System.out.println("----------------Estante----------------");
    }

    static void printMainMenu() {
        System.out.println("----------Guia dos Quadrinhos----------");
        System.out.println("-[1] - Novo quadrinho");
        System.out.println("-[2] - Minha cole????o");
        System.out.println("-[3] - Meu perfil");
        System.out.println("-[4] - Lista de desejos");
        System.out.println("-[5] - Carrinho");
        System.out.println("-[6] - Lan??amentos");
        System.out.println("-[7] - Editoras favoritas");
        System.out.println("-[0] - Sair");
        System.out.println("----------------Estante----------------");
        System.out.println("Digite sua op????o:");
    }
}