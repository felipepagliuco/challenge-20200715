

class CandidateVaga 
    include Capybara::DSL

    def confirm_vaga 
        find(".container .align-items-center").click 
    end

end



