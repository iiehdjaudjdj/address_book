package AddressBookSystemGUI;

import javax.swing.RowFilter;

public class Filter extends RowFilter {
	private String search;
	
	
	Filter(String search) {
		this.search = search.toLowerCase();
	}
	
	Filter() {
		
	}
	
	public boolean include(Entry entry) {
		
		 String entryValue = entry.getStringValue(1).toLowerCase();
	        return entryValue.contains(search);
	}

}
