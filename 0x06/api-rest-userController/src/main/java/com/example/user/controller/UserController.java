package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        try {
            if(id > 0 && id < 100){
                return "You have entered valid ID";
            }
        } catch (api.CPFException.CPFException e){
            new api.CPFException.CPFException().handelerCpf(e);
        }
        String msg = "You have entered invalid ID";
        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if(userName.length() > 3 && userName.length() < 15){
            return "You have entered valid USERNAME";
        }
        String msg = "You have entered invalid USERNAME";
        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if(cpf.length() > 3 && cpf.length() < 15){
            return "You have entered valid CPF";
        }
        String msg = "You have entered invalid CPF";
        boolean isCPFValid = isCPF(cpf);
        return msg;
    }

    public boolean isCPF(String CPF) {
        if(CPF.length() == 14){
            return true;
        }
        return false;
    }
}
