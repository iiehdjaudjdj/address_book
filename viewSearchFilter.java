package AddressBookSystemGUI;

import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;

public class viewSearchFilter extends RowFilter {
	
	private String search;
	private int itemToSearch;
	viewSearchFilter(String search , int itemToSearch) {
		this.search = search.toLowerCase();
		this.itemToSearch = itemToSearch;
	}
	
	viewSearchFilter() {
		
	}
	
	public boolean include(Entry entry) {
		
		 String entryValue = entry.getStringValue(itemToSearch).toLowerCase();
	        return entryValue.contains(search);
	}

}
