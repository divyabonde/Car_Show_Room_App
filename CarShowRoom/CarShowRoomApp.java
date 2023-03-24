import java.util.*;
import java.text.*;

class Audi{
	
	private String fuelType;
	private String engineType;
	private int engineCapacity;
	private int torque;
	private int topSpeed;
	private float mileage;
	private int seatCapacity;
	private double price;
	boolean isAvailable;
	
	public Audi()
	{
		
	}
	
	public Audi(String fuelType, String engineType, int engineCapacity, int torque, int topSpeed, float mileage,int seatCapacity, double price)
	{
		this.fuelType=fuelType;
		this.engineType=engineType;
		this.engineCapacity=engineCapacity;
		this.torque=torque;
		this.topSpeed=topSpeed;
		this.mileage=mileage;
		this.seatCapacity =seatCapacity;
		this.price=price;
		this.isAvailable= true;	
	}
	
	public double getPrice()
	{
		return this.price;
	}

	public int getseatCapacity()
	{
		return this.seatCapacity;
	}
	
	public String getfuelType()
	{
		return this.fuelType;
	}

	public void setIsAvailable(boolean isAvailable)
	{
		this.isAvailable= isAvailable;
	}

	public boolean getIsAvailable()
	{
		return this.isAvailable;
	}
	
 	public String getNameOfModel()
	{
		return "";
	}
	public int getTopSpeed()
	{
		return this.topSpeed;
	}
	
	public double getMileage()
	{
		return this.mileage;
	}
	
	public double getTorque()
	{
		return this.torque;
	}

	public double getEngineCapacity()
	{
		return this.engineCapacity;
	}
	public String getEngineType()
	{
		return this.engineType;
	}

}
class Series extends Audi
{
	public String nameOfModel;

	public Series()
	{
		
	}
	
	public Series(String nameOfModel, double price, String fuelType, String engineType, int engineCapacity, int torque, int topSpeed, float Mileage, int seatCapacity)
	{
		super(fuelType,engineType,engineCapacity,torque,topSpeed,Mileage,seatCapacity,price);
		this.nameOfModel=nameOfModel;
	}
	
	//@override
 	public String getNameOfModel()
	{
		return this.nameOfModel;
	} 
	
	//@override
	public String toString()
	{
		return "\nName of Model    : "+this.getNameOfModel()+"\nPrice of Car     : "+this.getPrice()+ "Lakhs "+" \nFuel Type        : "+this.getfuelType()+ "\nEngine Type      : "+this.getEngineType() +"\nEngine Capacity  : "+this.getEngineCapacity()+" cc" + "\nTorque           : "+this.getTorque() + " Nm"+"\nTop Speed        : "+this.getTopSpeed()+ " kmph"+"\nMileage          : "+this.getMileage()+ " kmph"+"\nSeat Capacity    : "+this.getseatCapacity() + " Seats\n";
	}

	// Price Sort
	public static void priceSort(Audi[]audiArr)
	{
		Audi temp;
		for(int i=0; i< audiArr.length; i++)
		{	
			for(int j=i+1; j< audiArr.length; j++)
			{

				if( audiArr[i].getPrice() > audiArr[j].getPrice() )
				{
					temp= audiArr[i];
					audiArr[i]= audiArr[j];
					audiArr[j]= temp;
				}
			}
		}

		for(int i=0; i< audiArr.length; i++)
		{
			if( ! (audiArr[i].getIsAvailable()) )
				continue;
			System.out.println( audiArr[i] );
			System.out.println("_______________________________________________");

		}
	}

// Mileage Sort
	public static void mileageSort(Audi[]audiArr)
	{
		Audi temp;
		for(int i=0; i< audiArr.length; i++)
		{	
			for(int j=i+1; j< audiArr.length; j++)
			{

				if( audiArr[i].getMileage() > audiArr[j].getMileage() )
				{
					temp= audiArr[i];
					audiArr[i]= audiArr[j];
					audiArr[j]= temp;
				}
			}
		}

		for(int i=0; i< audiArr.length; i++)
		{
			if( ! (audiArr[i].getIsAvailable()) )
				continue;
			System.out.println( audiArr[i] );
			System.out.println("_______________________________________________");
		}
	}

// Top Speed Sort
	public static void topSpeedSort(Audi[]audiArr)
	{
		Audi temp;
		for(int i=0; i< audiArr.length; i++)
		{	
			for(int j=i+1; j< audiArr.length; j++)
			{

				if( audiArr[i].getTopSpeed() > audiArr[j].getTopSpeed() )
				{
					temp= audiArr[i];
					audiArr[i]= audiArr[j];
					audiArr[j]= temp;
				}
			}
		}

		for(int i=0; i< audiArr.length; i++)
		{
			if( ! (audiArr[i].getIsAvailable()) )
				continue;
			System.out.println( audiArr[i] );
			System.out.println("_______________________________________________");
		}
	}

	public static void inputModelName(Audi[] audiArr, String ser)
	{
		Scanner sc= new Scanner(System.in);
		int flag=0;
		do
		{
			flag=0;
			System.out.println("_______________________________________________");
			System.out.println("\nEnter the Car's Model name of Audi "+ser+" Series which you want to buy  : ");
			String choice= sc.next();
			String str= choice.toUpperCase();
			boolean b= false;
			if((str.charAt(0)== ser.charAt(0)))
			{
				
				for(int i=0; i< audiArr.length; i++ )
				{

				if(str.equals( ((Series)audiArr[i]).nameOfModel) )
					{
						{
					 		buyCar(audiArr, str);
							b= true;
						}
					}
				
				}
				if(!b)
				{
					System.out.println("\nOops.. !!! You have entered a wrong Model Name \nPlease Enter a valid input of the Audi "+ser+" Series  : ");
						flag=1;
				}
					
				
				
			}
			else
			{
				System.out.println("\nOops.. !!! You have entered a wrong Model Name \nPlease Enter a valid input of the Audi "+ser+" Series  : ");
				flag=1;
			}
		} while(flag==1);	
	}

	// For Series specific cars
	public static void buyCar(Audi audiArr[], String s)
	{
		Scanner sc= new Scanner(System.in);
		int verify= 0;
		Audi selectedCar= null;
		do
		{

			String str= s;
			verify= 0;
			
			for(int i=0; i< audiArr.length; i++ )
			{

				if(str.equals( ((Series)audiArr[i]).nameOfModel) )
				{
					selectedCar= audiArr[i];
					verify= 1;
					//continue;
				}
			}
			if(verify == 0)
				System.out.println("\nOops.. !!! You have entered a wrong Model Name \nPlease Enter a valid input  : \n");
		} while(verify == 0);
		
		if(selectedCar.getIsAvailable())
		{
			int flag= 0;
			String color=null;

			do
			{
				flag=0;
				
				System.out.println("Choose the color of the Car  : \n1 >> Ibis White\n2 >> Silver Metallic\n3 >> Gray Pearl\n4 >> Mythos Black Metallic\n5 >> Navarra Blue Metallic \n\nEnter your choice  : ");

				int ch= sc.nextInt();
				switch(ch)
				{
					case 1:
						{
							color= "Ibis White";
							break;
						}
					case 2: 
						{
							color= "Silver Metallic";
							break;
						}
					case 3: 
						{
							color= " Gray Pearl";
							break;
						}
					case 4: 
						{
							color= "Mythos Black Metallic";
							break;
						}	
					case 5: 
						{
							color= "Navarra Blue Metallic";
							break;
						}
					default:
						{
							System.out.println("\nInvalid input.. !!! \nEnter valid choice  : \n");
							flag=1;
							break;
						}
				} 
			
			}while(flag==1);
			System.out.println("_______________________________________________");
			System.out.println("\nYou have choose  : Audi "+((Series)selectedCar).nameOfModel+"\nColor\t\t : "+color );
			System.out.println("_______________________________________________");
			System.out.println("\nTo confirm the booking and to generate a bill receipt Enter 1  : \nTo cancel the process Enter 0  : ");
			int ch= sc.nextInt();
			if(ch==1)
			{	
				selectedCar.setIsAvailable(false);
				Customer.receipt(selectedCar);
			}
			else
				System.out.println("Process Cancelled.. ");
		}
		else
			System.out.println("Selected Car Audi "+((Series)selectedCar).getNameOfModel()+ " is Not Available in the Showroom");
	
	}


	//For other cars : Overloaded
	public static void buyCar(Audi audiArr[])
	{
		Scanner sc= new Scanner(System.in);
		int verify= 0;
		Audi selectedCar= null;
		do
		{
			verify= 0;
			System.out.println("/nEnter the Car's Model name which you want to buy  : ");
			String choice= sc.next();
			String str= choice.toUpperCase();
		

			for(int i=0; i< audiArr.length; i++ )
			{

				if(str.equals( ((Series)audiArr[i]).nameOfModel) )
				{
					selectedCar= audiArr[i];
					verify= 1;
					//continue;
				}
			}
			if(verify == 0)
				System.out.println("\nOops.. !!! You have entered a wrong Model Name \nPlease Enter a valid input  : \n");
		}while(verify == 0);

		if(selectedCar.getIsAvailable())
		{

			int flag= 0;
			String color=null;
			
			do
			{
				flag=0;
				System.out.println("Choose the color of the Car  : \n1 >> Ibis White\n2 >> Silver Metallic\n3 >> Gray Pearl\n4 >> Mythos Black Metallic\n5 >> Navarra Blue Metallic \nEnter your choice  : ");
				int ch= sc.nextInt();
				switch(ch)
				{
					case 1:
						{
							color= "Ibis White";
							break;
						}
					case 2: 
						{
							color= "Silver Metallic";
							break;
						}
					case 3: 
						{
							color= " Gray Pearl";
							break;
						}
					case 4: 
						{
							color= "Mythos Black Metallic";
							break;
						}	
					case 5: 
						{
							color= "Navarra Blue Metallic";
							break;
						}
					default:
						{
							System.out.println("\nInvalid input.. !!!\nEnter valid Color choice  : \n");
							flag=1;
							break;
						}
				} 
			
			}while(flag==1);
			System.out.println("\n_______________________________________________");
			System.out.println("\nYou have choose  : Audi "+((Series)selectedCar).nameOfModel+"\nColor\t\t : "+color );
			System.out.println("_______________________________________________\n");

			System.out.println("\nTo confirm the booking and to generate a bill receipt Enter 1  : \nTo cancel the process Enter 0  : ");
			int ch= sc.nextInt();
			if(ch==1)
			{
				selectedCar.setIsAvailable(false);
				Customer.receipt(selectedCar);
			}
			else
				System.out.println("Process Cancelled.. ");
	}
	else 
		System.out.println("Selected Car Audi "+((Series)selectedCar).getNameOfModel()+ "is Not Available in the Showroom");
		
	} 
	
}

class Customer
{
	String custName;
	String phoneNo;
	String city;

	Customer(String custName, String phoneNo, String city)
	{
		this.custName= custName;
		this.phoneNo= phoneNo;
		this.city= city;
	}

	public void printCustInfo()
	{
		System.out.println("Costumer's name : "+this.custName+ "\nPhone No.  : "+this.phoneNo+ "\nCity  : "+this.city);
	}

	public void printBillReceipt(Audi selectedCar, Customer cust1)
	{
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date= new Date();
        SimpleDateFormat b = new SimpleDateFormat("hh:mm a");

		System.out.println("________________________________________________________________________________________________________________\n");
		
		System.out.println("\n\n\n\t\t\t ********RECEIPT OF BILL********\n");
		
		System.out.println("\n\t\t\t_________CUSTOMER INFORMATION_________");
        System.out.println("\n----------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %30s %30s %20s", "DATE", "CUSTOMER'S NAME", "PHONE NO.", "CITY");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------");

        System.out.printf("%12s",sdf.format(date));
        System.out.format("%30s %30s %20s"  ,this.custName, this.phoneNo, this.city);
        System.out.println();

        System.out.println("\n\n\t\t\t_________CAR INFORMATION_________\n");
       	
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s %30s %35s", "BRAND", "MODEL NO.", "SHOWROOM PRICE (Rs)");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------");

        System.out.format("%10s %25s" ,"AUDI", selectedCar.getNameOfModel() );
		System.out.printf("%30.2f Lakhs",selectedCar.getPrice() );
        System.out.println("\n\n");

		
		System.out.println("____________________"+"                                                      "+"____________________");
		System.out.println("Owner's Signature"+"                                                          "+"Customer Signature");

		System.out.println("\n\nThank You Mr/Mrs "+this.custName+" for Trusting us with your purchase... ");
		System.out.println("\nWishing you a Happy and Safe Driving... :) \n");
		
		System.out.println("________________________________________________________________________________________________________________\n");


    
	}

	public static void receipt(Audi selectedCar)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("\n_______________________________________________\n");
		System.out.println("-------Enter Customer Info-------\n");
		System.out.println("Enter your Name  : ");
		String custName= sc.nextLine();

		System.out.println("Enter your Phone no.  : ");
		String phoneNo= sc.nextLine();

		System.out.println("Enter your City  : ");
		String city= sc.nextLine();

		Customer cust1= new Customer(custName, phoneNo, city);

		cust1.printBillReceipt(selectedCar, cust1);

	}
}

class CarShowRoomApp{
	
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);

		Audi A4 = new Series("A4",43.50,"Petrol","4 Cylinder",1984, 320, 230, 20.12f, 5);
		Audi A6 = new Series("A6",57.04,"Petrol","6 Cylinder",1984, 320, 241, 18.12f, 5);
		Audi A8 = new Series("A8",150.25,"Petrol","6 Cylinder",2995, 450, 250, 15.12f,4);
	 
		Audi Q2 = new Series("Q2",35.50,"Petrol","4 Cylinder",1984, 4000, 228, 23.12f,4);
		Audi Q3 = new Series("Q3",40.50,"Petrol","6 Cylinder",2220, 450, 222, 21.50f, 4);
		Audi Q5 = new Series("Q5",75.30,"Petrol","4 Cylinder",2995, 500, 250, 20.12f, 5);
		Audi Q8 = new Series("Q8",95.15,"Petrol","6 Cylinder",2995, 550, 245, 17.85f, 5);
 
		Audi RS5  = new Series("RS5",104.05,"Petrol","4 Cylinder",2894,650, 255, 10.12f,5);
		Audi RS7  = new Series("RS7",194.50,"Petrol","6 Cylinder",3996,800, 250, 13.12f,4);
		Audi RSQ8 = new Series("RSQ8",200.07,"Petrol","6 Cylinder",3996,800,250 ,15.12f,5);
		 

        Audi audiArr[] = {A4,A6,A8,Q2,Q3,Q5,Q8,RS5,RS7,RSQ8};

		int mainFlag= 0; 
		do
		{
			mainFlag= 0;

			System.out.println("\n*****************************************************************************************");

			System.out.println();
			System.out.println("\t\t\t-----WELCOME TO AUDI CAR SHOWROOM-----\n");
			
			System.out.println();
			
			System.out.println("****************************************************************************************\n");
			System.out.println("_________________________________________________________________________");
			
			//prints only names of all models 
			System.out.println("\n\t\t\t-------MODEL NAMES OF CAR-------      ");
			System.out.println("\n\t\t\t    ----A Series Cars----    \n");
			
			for(int i=0; i<audiArr.length; i++)
			{
				if( ( ((Series)(audiArr[i])).getNameOfModel() ).charAt(0)== 'A')
				System.out.print("\t\t\t\t" +"Audi "+ ((Series)(audiArr[i])).getNameOfModel() +"\n" );
			} 

			System.out.println("\n\t\t\t    ----Q Series Cars----   \n");
			for(int j=0; j<audiArr.length; j++)
			{
				if( ( ((Series)(audiArr[j])).getNameOfModel() ).charAt(0)== 'Q')
				System.out.print("\t\t\t\t" +"Audi "+ ((Series)(audiArr[j])).getNameOfModel() +"\n" );
			} 

			System.out.println("\n\t\t\t   ----RS Series Cars----    \n");
			for(int k=0 ; k<audiArr.length; k++)
			{
				if( ( ((Series)(audiArr[k])).getNameOfModel() ).charAt(0)== 'R')
				System.out.print("\t\t\t\t" +"Audi "+ ((Series)(audiArr[k])).getNameOfModel() +"\n" );
			} 	System.out.println();
			
			System.out.println("_________________________________________________________________________");
			
			//Main switch case
			int invld=0;
			do
			{
				invld= 0;
			System.out.println("Select your choice  : ");
			System.out.println("1 >> According to Price \n2 >> According to Mileage \n3 >> According to Top Speed \n4 >> According to Series of Cars ");
			int choice= sc.nextInt();

			switch(choice)
			{
		
				case 1:

						{
							
							Series.priceSort(audiArr); 
							Series.buyCar(audiArr);
							break;
						}

				case 2:
						{
							Series.mileageSort(audiArr);
							Series.buyCar(audiArr);
							break;
						}

				case 3:
						{
							Series.topSpeedSort(audiArr);
							Series.buyCar(audiArr);
							break;
						}

				case 4: 
				{

					int flag=0;
					do
					{
						flag= 0;
				
						
						System.out.println("Select the option  : ");
						System.out.print("1: To get the info of the \"Audi A\" Series cars \n2: To get the info of the \"Audi Q\" Series cars \n3: To get the info of the \"Audi RS\" Series cars \nEnter your Choice  : ");
						int ch= sc.nextInt();

						switch(ch)
						{
							case 1: 
								{
									for(int j=0; j<audiArr.length; j++)
									{	
									  if( ( ((Series)(audiArr[j])).getNameOfModel() ).charAt(0)== 'A')
									  {
										if( ! (audiArr[j].getIsAvailable()) )
											continue;
										System.out.println("---------------------- "+audiArr[j].getNameOfModel()+"  Car Information----------------------------");
										System.out.println( audiArr[j] );
									  }
									}
									Series.inputModelName(audiArr,"A");
									break;
								}
							case 2: 
								{
									for(int j=0; j<audiArr.length; j++)
									{
									  if( ( ((Series)(audiArr[j])).getNameOfModel() ).charAt(0)== 'Q')
									  {
										if( ! (audiArr[j].getIsAvailable()) )
											continue;
										System.out.println("---------------------- "+audiArr[j].getNameOfModel()+"  Car Information----------------------------");
										System.out.println( audiArr[j] );
									  }
									}
									Series.inputModelName(audiArr,"Q");
									break;

								}
							case 3:
								{
									for(int j=0; j<audiArr.length; j++)
									{
									  if( ( ((Series)(audiArr[j])).getNameOfModel() ).charAt(0)== 'R')
									  {
										if( ! (audiArr[j].getIsAvailable()) )
											continue;
										System.out.println("---------------------- "+audiArr[j].getNameOfModel()+"  Car Information----------------------------");
										System.out.println( audiArr[j] );
									  }
									}
									Series.inputModelName(audiArr,"RS");
									break;
								}
							default : 
									{
										System.out.println("\nInvalid Input \nEnter valid choice  : \n");
										flag= 1;

										break;
									}
						}
					
					}while (flag == 1);
					break;
				
				}

				default: 
					{
						System.out.println("\nInvalid Input.. !!! \nEnter valid choice  : \n");
						invld= 1;

						break;
					}

				}
			} while(invld == 1);

			System.out.println("\n\nThanks for Visiting... :) ");
			

			System.out.println("\n\nTo Continue Enter 1 \nTo Exit Enter 0 \nEnter your choice  : ");
			mainFlag= sc.nextInt();
			
			
		}while(mainFlag==1);

	}
}