
class HomePage
    include Capybara::DSL
    
    def go
        visit "/"
    end 

    def click_vagas(button)
        find('#navBar').find_link(button).click
    end


end

