package com.ty.springboot_hospital_app.util;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import antlr.collections.List;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class ApplicationConfig {
	public Docket getDocket() {
		Contact contact=new Contact("TestYantra", "www.testyantra.com", "tysupport@gmail.com");
		java.util.List<VendorExtension> extension=new ArrayList<VendorExtension>();
		ApiInfo api=new ApiInfo("HospitalApp", "hospital v1.0", "Vesion 1.0", "www.tyglobal@gmail.com", contact, "afd@12334", "ww.ty.com", extension);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospital_app")).build().apiInfo(api).useDefaultResponseMessages(false);
	}

}
