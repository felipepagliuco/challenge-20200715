Dado('que eu acesso a o site da Coodesh') do
    @home_page.go
end

E('eu devo pressionar o botão: {string}') do |button_vagas|
    @home_page.click_vagas(button_vagas)
end

Dado('estando na página eu preeencho no campo Categoria por: {string} e confirmo.') do |vaga|
    @vaga_page.setVaga(vaga)
    @vaga_page.buttonVaga
end

E('então eu clico na vaga de: {string}') do |vagas|
    @vaga_page.confirm_vaga(vagas)
end

Quando('Pressiono o botão de Candidatar-se') do
    @candiate_page.confirm_vaga   
end

Então('eu deva ver a o forulário para preenchimento da vaga') do
    expect(".modal-content").to be_truthy 
end

