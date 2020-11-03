package me.cheonhwa.bookyouthspace.config;

import me.cheonhwa.bookyouthspace.domain.Visitor;
import me.cheonhwa.bookyouthspace.domain.VisitorForm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.createTypeMap(VisitorForm.class, Visitor.class)
                .addMappings(mapper ->mapper.using(
                        ctx -> LocalDate.parse((String)ctx.getSource())).map(VisitorForm::getReservedDate,Visitor::setReservedDate));
        return modelMapper;
    }

}
