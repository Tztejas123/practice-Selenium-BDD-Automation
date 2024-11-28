package com.agastya.stepDefination;

import java.util.HashMap;
import io.cucumber.core.cli.Main;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterisation {
	int result =0;
	int x,y;
	@Given("I have {int} and {int}")
	public void i_have_and(Integer int1, Integer int2) {
	    x=int1;
	    y=int2;
	}

	@When("i add them")
	public void i_add_them() {
	   result=x+y;
	}

	@Then("check if the result is prime")
	public void check_if_the_result_is_prime() {
	    int count=1;
	    for (int i = 1; i < result/2; i++) {
	    if (result%i==0) {
			count++;
		}
			if (count>2) {
				
			} else {
			}
			System.out.println(result+"is prime");
		}
	}
	@Given("I have following pair of numbers")
	public void dataTableExample(DataTable table){
		HashMap map= (HashMap) table.asMap();
		)
	}

}
