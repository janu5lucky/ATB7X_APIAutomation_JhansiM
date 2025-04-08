package com.api.qa.CRUD.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class assertion_map_json_assertJ_Ex_004 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
			Map<String, Integer> ages = new HashMap<>();
			ages.put("john",30);
			ages.put("kiran",25);
			ages.put("kiara",20);
			ages.put("kusum",35);
			assertThat(ages).hasSize(4).containsEntry("john", 30).doesNotContainValue(40);
			System.out.println(ages);
			
		}

	}

	
