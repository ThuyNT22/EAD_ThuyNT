package org.example.eadtest_thuynt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EadtestThuyntApplication {

	public static void main(String[] args) {
		SpringApplication.run(EadtestThuyntApplication.class, args);
	}
}
