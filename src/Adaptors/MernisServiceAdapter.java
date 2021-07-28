package Adaptors;

import java.rmi.RemoteException;
import java.util.Locale;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		
		boolean result=false;
		
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),
					customer.getFirstName().toUpperCase(new Locale("tr","TR")),
					customer.getLastName().toUpperCase(new Locale("tr","TR")),
					customer.getDateOfBirth()
					);
			
		} catch (NumberFormatException | RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		
		
		
		return result;
	}

}
