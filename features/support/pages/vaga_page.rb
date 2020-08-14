

class VagaPage 
    include Capybara::DSL


    def setVaga(vaga)
        find("input[name='search']").set vaga
    end

    def buttonVaga
        procurar = find('.btn-block')
        procurar.set "disabled=false"
        procurar.click
    end

    def confirm_vaga(vagas)
        find_link(vagas).click
    end


end