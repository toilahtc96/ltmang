package datdai;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientController {
	private ClientView view;
	private String serverHost = "localhost";
	private int serverPost =1996;
	private Socket mySocket;
	private ObjectInputStream ios;
	private ObjectOutputStream oos;
	public ClientController() {
		try {
			mySocket = new Socket(serverHost, serverPost);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ios = new ObjectInputStream(mySocket.getInputStream());
		}catch (Exception e) {
		}
	}
	public void DangNhap(int machulo) {
		try {
			oos.writeObject(1);
			oos.writeObject(machulo);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<LoDat> getLoDatByMaChuLo(int machulo){
		ArrayList<LoDat> loDatByMaChuLo = null;
		try {
			oos.writeObject(2);
			oos.writeObject(machulo);
			System.out.println("before send");
			System.out.println(ios.readObject());
			loDatByMaChuLo = (ArrayList<LoDat>) (ios.readObject());
			System.out.println("iam: "+loDatByMaChuLo);
			System.out.println(loDatByMaChuLo.get(0).toString());
			System.out.println("after send");
			System.out.println("size: " +loDatByMaChuLo.size());
		}catch (Exception e) {
		}
		return loDatByMaChuLo;
	}
	public boolean updateMaChuLo(int machulo,int maUpdate) {
		boolean kq = false;
		try {
			oos.writeObject(3);
			oos.writeObject(machulo);
			oos.writeObject(maUpdate);
			 kq = (boolean) ios.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	public boolean updateScay(int machulo,int maLo,double Scay) {
		boolean kq = false;
		try {
			oos.writeObject(4);
			oos.writeObject(machulo);
			oos.writeObject(maLo);
			oos.writeObject(Scay);
			kq = ios.readBoolean();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	public boolean addLoDat(LoDat lodat) {
		boolean kq = false;
		try {
			oos.writeObject(5);
			oos.writeObject(lodat);
			kq = (boolean)(ios.readObject());
			System.out.println(kq);
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
}
