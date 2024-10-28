package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;

public class AccessRightsResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("UserName")
	private String userName;

	@XmlElementName("LastLogin")
	private String lastLogin;

	@XmlElementName("MenuList")
	private List<Menu> menuList;

	/**
	 * @return the transaction reference number
	 */
	public String getTxnRefNo() {
		return txnRefNo;
	}

	/**
	 * @param txnRefNo the transaction reference number to set
	 */
	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	/**
	 * @return the name of the card holder
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the name of the card holder to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the last login time of the customer
	 */
	public String getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the last login time to set
	 */
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the list of menu rights for the user
	 */
	public List<Menu> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList the list of menu rights to set
	 */
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessRightsResponse [txnRefNo=").append(txnRefNo).append(", userName=").append(userName)
				.append(", lastLogin=").append(lastLogin).append(", menuList=").append(menuList).append("]");
		return builder.toString();
	}

	public static class Menu {
		@XmlElementName("TMenu")
		private String tMenu;

		@XmlElementName("SMenu")
		private String sMenu;

		/**
		 * @return the main menu name
		 */
		public String getTMenu() {
			return tMenu;
		}

		/**
		 * @param tMenu the main menu name to set
		 */
		public void setTMenu(String tMenu) {
			this.tMenu = tMenu;
		}

		/**
		 * @return the sub-menu name
		 */
		public String getSMenu() {
			return sMenu;
		}

		/**
		 * @param sMenu the sub-menu name to set
		 */
		public void setSMenu(String sMenu) {
			this.sMenu = sMenu;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Menu [tMenu=").append(tMenu).append(", sMenu=").append(sMenu).append("]");
			return builder.toString();
		}
	}
}
