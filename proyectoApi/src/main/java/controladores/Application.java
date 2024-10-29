package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.DtoClubes;
import dtos.DtoUsuario;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;

public class Application
{
	public static List<DtoClubes> listaClubes = new ArrayList<DtoClubes>();
	public static List<DtoUsuario> listaUsuarios = new ArrayList<DtoUsuario>();
	public static void main( String[] args )
	{
		Scanner sc= new Scanner(System.in);
		OperativaInterfaz op = new OperativaImplementacion();
		int opc;
		boolean cerrarMenu = false;
		do {
		System.out.println("0.Cerrar Menu");
		System.out.println("1.Dar alta Club");
		System.out.println("2.Eliminar Club");
		opc=sc.nextInt();
			switch (opc) {
			case 0:
				System.out.println("Se cerrara la aplicacion");
				cerrarMenu = true;
				break;
			case 1:
				System.out.println("Entro Alta club");
				
				op.altaClub();
				break;
			case 2:
				System.out.println("Entro en clubs");
				
				break;

			default:
				System.out.println("Esta opcion no existe");
				break;
			}

		} while (!cerrarMenu);
	}
}