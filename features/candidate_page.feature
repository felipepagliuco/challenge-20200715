#language: pt

Funcionalidade: Página de Candiatura
    Para que eu possa me candidatar a um cargo na Coodesh
    Sendo um testador 
    Eu deva passar pelos seguintes passos para validar o caminho percorrido até a última tapa de candiatura 

@candidatee
Cenário: Candidatar à vaga 
        Dado que eu acesso a o site da Coodesh
        E eu devo pressionar o botão: "Vagas"
        E estando na página eu preeencho no campo Categoria por: "Vue.js" e confirmo. 
        E então eu clico na vaga de: "Pessoa Desenvolvedora Ruby On Rails"
        Quando Pressiono o botão de Candidatar-se
        Então eu deva ver a o forulário para preenchimento da vaga

    