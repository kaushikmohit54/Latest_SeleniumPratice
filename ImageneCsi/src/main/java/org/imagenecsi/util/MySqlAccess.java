package org.imagenecsi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;

public class MySqlAccess {

	private static final Logger logger = LogManager.getLogger(MySqlAccess.class
			.getName());

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	// Retrieve the apprefno to internal from table
	public String getworkerName() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			System.out.println("connect ***** " + connect);
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT REG_NO FROM apjatigo_idn_env2.APJ_REGISTRATION where Date(CREATE_DT) =CURDATE() order by WRKR_PROF_ID desc");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("Reg NO : " + resultSet.getString(1));
			return resultSet.getString(1);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();

		} finally {
			close();
		}

	}

	public String updatestatusforBMS() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			System.out.println("connect ***** " + connect);
			statement = connect.createStatement();

			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='BMS_FIT', PAYMENT_STATUS='PMT_BMS_REL' where Date(CREATE_DT) =CURDATE() and CREATE_ID='potpotua';");
			resultSet = statement
					.executeQuery("SELECT REG_NO FROM apjatigo_idn_env2.APJ_REGISTRATION where Date(CREATE_DT) =CURDATE() order by WRKR_PROF_ID desc");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("Reg NO : " + resultSet.getString(1));
			return resultSet.getString(1);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();

		} finally {
			close();
		}

	}

	// Method to retrieve first payment invoice number
	public String getFirstPaymentInvoiceNo() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT  INVOICE_NO FROM apjatigo_mys_env2.APJ_PAYMENT_INVOICE  where INVOICE_TYPE='S1' and date(CREATE_DT)=CURDATE()  order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	// Method to retrieve payment invoice number
	public String getSecondPaymentInvoiceNo() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT  INVOICE_NO FROM apjatigo_mys_env2.APJ_PAYMENT_INVOICE  where INVOICE_TYPE='S2' and date(CREATE_DT)=CURDATE()  order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	// Updated by Sreeramya **** Method to retrieve Payment invoice number for
	// third Payment

	public String getThirdPaymentInvoiceNo() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_INVOICE where date(CREATE_DT)=CURDATE() order by date(CREATE_DT) desc;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	// Method to retrieve ref no update status eVDR-PRA
	public String updateStatus() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='VDR_APR' where PAYMENT_STATUS='PMT_RT1_REL' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			resultSet = statement
					.executeQuery("SELECT * FROM apjatigo_mys_env2.APJ_REGISTRATION where  Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}
	


	// Method to check arrival info
	public String updateArrivalInfo() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='ARRIVED' where date(UPDATE_DT)=curdate() AND PAYMENT_STATUS ='PMT_BMS_REL';");
			resultSet = statement
					.executeQuery("SELECT * FROM apjatigo_idn_env2.APJ_REGISTRATION;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	// Method to check info
	public String updatePLKSInfo() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='PLKS_APR' where date(UPDATE_DT)=curdate() AND STATUS='FOMEMA_PASS';");
			resultSet = statement
					.executeQuery("SELECT * FROM apjatigo_idn_env2.APJ_REGISTRATION;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}

	}

	public String firstOnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P1_BOOK_PPMI_APR' and PROF_TYPE='APS' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	public String secondOnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_mys_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P1_VDR_APR' and PROF_TYPE='APS' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}
	
	
	public String thirdOnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_mys_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P1_FOMEMA' and PROF_TYPE='APS' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	public String Secondp2OnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P2_VDR_APR' and PROF_TYPE='PT' and PROF_ID='10'  and PAYMENT_STATUS='INIT' and Date(CREATE_DT) =CURDATE() order by CREATE_DT asc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}


	public String Thirdp2OnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P2_VDR_APR' and PROF_TYPE='PT' and PROF_ID='10'  and PAYMENT_STATUS='INIT' and Date(CREATE_DT) =CURDATE() order by CREATE_DT asc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String p3OnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P3_VDR_APR' and PROF_TYPE='PT' and PROF_ID='10'  and PAYMENT_STATUS='INIT' and Date(CREATE_DT) =CURDATE() order by CREATE_DT asc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}
	
	public String p5OnlineRemittance() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DatabaseProp.getmysqlUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_mys_env2.APJ_PAYMENT_DTL where PAYMENT_TYPE='P5_VDR_APR' and PROF_TYPE='PT' and PROF_ID='10'  and PAYMENT_STATUS='INIT' and Date(CREATE_DT) =CURDATE() order by CREATE_DT asc limit 1;");

			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("PAYMENT INVOICE NUM : "
					+ resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}
	
	
	
	
	
	public String updatesuccesspage() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_PAYMENT_DTL set PAYMENT_STATUS='PAID'  where PAYMENT_TYPE='P1_BOOK_PPMI_APR' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_BOOKING_PAYMENT set PAYMENT_STATUS='PAID', LOCKED='Y' where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set PAYMENT_STATUS='PMT_RT1_REL' where STATUS='BOOK_PPPMI_APR' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_idn_env2.APJ_PAYMENT_DTL where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}

	}

	public String updateSecondP1successpage() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_BOOKING_PAYMENT set PAYMENT_STATUS='PAID'  where PAYMENT_DESC='VDR_APPROVED' and LOCKED='Y' and APS_PROF_ID='27' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_PAYMENT_DTL set PAYMENT_STATUS='PAID'  where PAYMENT_TYPE='P1_VDR_APR' and PROF_TYPE='APS' and PROF_ID='27' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_mys_env2.APJ_BOOKING_PAYMENT where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}

	}
	
	
	
	public String updateThirdP1successpage() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_BOOKING_PAYMENT set PAYMENT_STATUS='PAID'  where PAYMENT_DESC='FOMEMA_PASS'and APS_PROF_ID='27' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_PAYMENT_DTL set PAYMENT_STATUS='PAID'  where PAYMENT_TYPE='P1_FOMEMA' and PROF_TYPE='APS' and PROF_ID='27' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			resultSet = statement
					.executeQuery("SELECT INVOICE_NO FROM apjatigo_mys_env2.APJ_BOOKING_PAYMENT where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}

	}

	public String updateeVDRpage() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='VDR_APR' where PAYMENT_STATUS='PMT_RT1_REL' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_REGISTRATION set STATUS='VDR_APR' where PAYMENT_STATUS='PMT_RT1_REL' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			resultSet = statement
					.executeQuery("SELECT REG_NO FROM apjatigo_idn_env2.APJ_REGISTRATION where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

	public String updateFomemapage() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					DatabaseProp.getmysqlIDNUrl(),
					DatabaseProp.getmysqlUserName(),
					DatabaseProp.getmysqlPassword());
			statement = connect.createStatement();
			statement
					.executeUpdate("update apjatigo_idn_env2.APJ_REGISTRATION set STATUS='FOMEMA_PASS' where PAYMENT_STATUS='PMT_VDR_PEND' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			statement
					.executeUpdate("update apjatigo_mys_env2.APJ_REGISTRATION set STATUS='FOMEMA_PASS' where PAYMENT_STATUS='PMT_VDR_PEND' and Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");

			resultSet = statement
					.executeQuery("SELECT REG_NO FROM apjatigo_idn_env2.APJ_REGISTRATION where Date(CREATE_DT) =CURDATE() order by CREATE_DT desc limit 1;");
			System.out.println("resultSet  : " + resultSet);
			resultSet.next();
			System.out.println("STATUS : " + resultSet.getString(1));
			return resultSet.getString(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipException(e.getMessage(), e.getCause());
		} finally {
			close();
		}
	}

}