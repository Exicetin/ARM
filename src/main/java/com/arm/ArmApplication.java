package com.arm;


import com.arm.tables.Cards;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
public class ArmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ArmApplication.class, args);
//		CardRepository repository = context.getBean(CardRepository.class);//короч не обращай внимание на ошибки нужно билдануть проект чтобы спринг все сам создал вот этой фигней@EnableAutoConfiguration

		//repository.save(new Cards(1,"2345EMD",1123123,1,"22-10-2002","22-10-2002","22-11-2002","23456789"));//собственно это инсерт
		context.close();
	}

}
