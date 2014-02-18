import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Bitcoin {

	

//		Challenge 1 - Bitcoin to the future Ç Prev Next È It's what makes time travel possible
//		In the near future, after winning the Tuenti Challenge, you acquire almost supernatural programming skills. 
//		You write a Flux Capacitor Algorithm that is able to predict the exchange rate in euros of Bitcoin (the most used Internet currency) for a period of time. Now, you need to write a program that, given a list of Bitcoin exchange rates for a period of time and your initial budget, calculates the maximum number of euros that you are going to have at the end of the period. That is, the amount of euros you can earn plus your initial budget.
//
//		The exchange rate is always an integer, you can't buy a fraction of a bitcoin and you can sell or buy bitcoins at any moment, as many times as you want.
//
//		Input
//
//		First line contains the number of test cases, T, and T cases follow (each one in a different line). Each test case consists of one integer N (1 ² N ² 100), indicating your initial budget in euros. In the next line, there is a list of integers indicating the future value of Bitcoin at different times in a fixed period.
//
//		Output
//
//		The maximum amount of euros that you will have at the end, in a different line for each test case.
//
//		Example
//
//		Initial budget: 3
//		List of exchange rates: 1, 2, 10, 6
//		You buy at 1 euro per bitcoin and sell at 10 euros per bitcoin, so at the end you will have 30 euros.

		


	public static int MaximumMoney(int numberShares, int money, List<Integer> rates, String state){
		
		int buy = 0;
		int sell = 0;;
		int pass = 0;
		
		if(rates.size() == 0){
			return money;
		}
					
		if(state == "passed"){	//Case that passed in the step before
			
			System.out.println("Ha entrado en un passed, tiene a el rate "+rates.get(0)+" y los valores para numShares, money son "+numberShares +money);

			if((money > 0) && ((money%rates.get(0))==0)    ){
				int division = money/rates.get(0);
				List<Integer> list = new ArrayList<Integer>(rates);
				list.remove(0);
				buy = MaximumMoney(division,0,list,"bought");				
			}
			
			if((numberShares > 0)  ){
				int division = rates.get(0)*numberShares;
				System.out.println("Multiplica:" +division);
				List<Integer> list2 = new ArrayList<Integer>(rates);
				list2.remove(0);
				sell = MaximumMoney(0,division,list2,"sold");				
			}
			
			List<Integer> list3 = new ArrayList<Integer>(rates);
			list3.remove(0);
			pass = MaximumMoney(numberShares,money,list3,"passed");
			
			
		}else if(state == "sold"){	//Case that sold in the step before
			
			System.out.println("Ha entrado en un sold, tiene a el rate "+rates.get(0)+" y los valores para numShares, money son "+numberShares +money);

			if((money > 0) && ((money%rates.get(0))==0)    ){
				int division = money/rates.get(0);
				List<Integer> list = new ArrayList<Integer>(rates);
				list.remove(0);
				buy = MaximumMoney(division,0,list,"bought");			
			}
			List<Integer> list3 = new ArrayList<Integer>(rates);
			list3.remove(0);
			pass = MaximumMoney(numberShares,money,list3,"passed");
			
			
		}else if(state == "bought"){	//Case that bought in the step before
			
			
			System.out.println("Ha entrado en un bought, tiene a el rate "+rates.get(0)+" y los valores para numShares, money son "+numberShares +money);
			
			if((numberShares > 0)    ){
				int division = rates.get(0)*numberShares;
				List<Integer> list2 = new ArrayList<Integer>(rates);
				list2.remove(0);
				sell = MaximumMoney(0,division,list2,"sold");				
			}
			
			List<Integer> list3 = new ArrayList<Integer>(rates);
			list3.remove(0);
			pass = MaximumMoney(numberShares,money,list3,"passed");
		}
		System.out.println("Los valores para buy, sell y pass son: " + buy+ sell +pass);

		return merge(buy,sell, pass);
		
	}
	
	public static int merge(int a, int b, int c){
		return Math.max(Math.max(a, b), c);
	}

}
