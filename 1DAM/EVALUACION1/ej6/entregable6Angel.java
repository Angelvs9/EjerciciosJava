/*
 * entregable2Angel.java
 * 
 * Copyright 2023 Angel <Angel@OMEN>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.Scanner;
public class entregable6Angel {
	
	public static void main (String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int lado1;
		int lado2;
		int lado3;
		System.out.println("introduce el primer número");
		lado1=sc.nextInt();
		System.out.println("introduce el segundo número");
		lado2=sc.nextInt();
		System.out.println("introduce el tercer número");
		lado3=sc.nextInt();
		System.out.println("Los números introducidos " + lado1 +" "+ lado2 + " "+ lado3);
		
		
		
		
		if(lado1>lado2+lado3 || lado2>lado1+lado3 || lado3>lado1+lado2)
		{
		System.out.print("no se puede");	
		}
		
		
		else if (lado1 == lado2 && lado3 == lado2 && lado1 == lado3)
		{
			System.out.print("equilatero");
		}
		else if (lado1 != lado2 && lado3 != lado2 && lado1 != lado3)
		{
		
		System.out.print("escaleno");
		
		}
		else if(lado1 != lado2 || lado3 != lado2 || lado1 != lado3)
		{
			System.out.print("isosceles");
		}

			
			
			
	}
}

