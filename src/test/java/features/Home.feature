#language:pt
Funcionalidade: Home

  Cenário: : Verificar a se a página inicial esta sendo carregada corretamente
    Dado abra a pagina "https://coodesh.com/"
    Então deve ser apresentado o texto de um artigo carregado "Descubra quais são as mais importantes hard e soft skills de um DevOps"

  Cenário:  Navegar pela página e ir ao sistema de vagas no menu superior
    Dado abra a pagina "https://coodesh.com/"
    Quando clicar no link do sistemas de vagas
    Então o sistema de vagas deverá ser aberto permitindo o usuário buscar e visualizar vagas