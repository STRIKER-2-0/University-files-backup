package lab4;

public class Vehicle {
	public boolean position=false;	//��������������� ������	
	public double petrol_amount, tank_volume;	//��������� ������
	
	Vehicle(double petrol_amount, double tank_volume){
		if((petrol_amount<=tank_volume)&&(petrol_amount>0)&&(tank_volume>0)) {
			this.petrol_amount=petrol_amount;
			this.tank_volume=tank_volume;
		}
		else { 
			System.out.println("������������ ��������� ������. ��������! ����� ���������� ��������.");
			this.petrol_amount=100;
			this.tank_volume=100;
		}
	}
	double getTankVolume() {
		return tank_volume;
	}
	double getPetrolAmount() {
		return this.petrol_amount;
	}
	void arrive() {
		if(position==false) {
			Base.people_on_base++;
			Base.vehicles_on_base++;
			position=true;
		}
		else System.out.println("������. �������� ��� �� ����!");
	}
	boolean leave() {
		if(position==true) {			
			if((Base.people_on_base>=1)&&(Base.petrol_on_base>=tank_volume)) {
				Base.people_on_base--;
				Base.vehicles_on_base--;
				Base.petrol_on_base-=(tank_volume-petrol_amount);
				petrol_amount=tank_volume;
				position=false;
				return true;
			}
			return false;
		}
		else {
			System.out.println("������. �������� ��� �� �� ����!");
			return true;
		}
	}
}