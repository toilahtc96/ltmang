package datdai;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientView {
	public void menu() {
		ClientController controll = new ClientController();
		int chon;
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("----Menu---");
			System.out.println("0.Them moi Lo Dat");
			System.out.println("1.Xem Thong Tin Lo Dat ");
			System.out.println("2.Update thong tin chu lo");
			System.out.println("3.Update Dien Tich Cay");
			System.out.println("4.Xem Lich Su ");
			System.out.println("Please Choose: ");
			chon = Integer.parseInt(in.nextLine());
			switch (chon) {
			case 0:{
				System.out.println("Nhap ma loi");
				int malo = Integer.parseInt(in.nextLine());
				System.out.println("Nhap ma chu lo:i");
				int machulo = Integer.parseInt(in.nextLine());
				System.out.println("Nhap dia diem:s");
				String diadiem = in.nextLine();
				System.out.println("Nhap Scay:d");
				double sCay = Double.parseDouble(in.nextLine()); 
				System.out.println("Nhap SDat:d");
				double sDat = Double.parseDouble(in.nextLine());
				System.out.println("Nhap status i:");
				int status = Integer.parseInt(in.nextLine());
				LoDat lodat = new LoDat(malo,machulo,diadiem,sCay,sDat,status);
				boolean kq = controll.addLoDat(lodat);
				System.out.println("acaca: "+controll.addLoDat(lodat));
				if(kq == true) {
					System.out.println("susscess");
				}
				else {
					System.out.println("Chua add");
				}
				break;
			}
			case 1:{
				LoDat LoDatLast = new LoDat(); 
				System.out.println("Nhap Ma Chu Lo : ");
				int machulo = Integer.parseInt(in.nextLine());
				ArrayList<LoDat> allLoDat = controll.getLoDatByMaChuLo(machulo);
				System.out.println(allLoDat.size());
				for (LoDat loDat : allLoDat) {
					if(loDat.getStatus() == 0)
						LoDatLast = loDat;
				}
				System.out.println("Thong tin lo dat: "+LoDatLast.toString());
				
				break;
			}
			default:
				break;
			}
			
			
		}
	}
	
}
