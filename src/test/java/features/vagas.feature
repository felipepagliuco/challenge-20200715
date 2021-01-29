#language:pt
Funcionalidade: Busca e candidatura de vagas

  Cenário: Uma vez na tela de vagas, nosso sistema de teste automatizado terá que buscar pela empresa de VipCommerce onde terá um ou mais resultados
  Dado que esteja na tela de vagas
  Quando buscar pela empresa "VipCommerce"
  Então deverá ser apresentado "3" resultados contendo os titulos
    | Scrum Master (Remoto)   |
    | DevOps (100% remote) |
    | Fullstack Developer |

  Cenário: Depois obter o resultado, deveremos abrir a vaga e revisar se o carregamento é realizado com sucesso ou não;
  Dado que esteja na tela de vagas
  Quando buscar pela empresa "VipCommerce"
  E clicar no titulo da vaga
  Então a pagina deve ser exibida com sucesso

  Cenário: Precisamos saber se o sistema de canditar está funcionando e para isso é necessário clicar no botão Candidatar-se e revisar se abriu o modal corretamente.
  Dado que esteja na tela de vagas
  Quando buscar pela empresa "VipCommerce"
  E clicar no titulo da vaga
  E clicar no botão Candidatar-se
  Então o modal deve ser aberto corretamente