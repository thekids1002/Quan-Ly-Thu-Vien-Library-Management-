package GUI;

public class Main extends Thread{
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
		
		} catch (InstantiationException ex) {
			
		} catch (IllegalAccessException ex) {
			
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			
		}
	
		LoginForm login = new LoginForm();
		login.setVisible(true);
		Login();
	}
	
	public static void Sleep(long j) {
		try {
			Thread.sleep(j);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	public static void Login() {
		System.out.println("Hello word");
		while(!LoginForm.dangnhap) {
			Sleep(1000);
		}
		if(LoginForm.dangnhap) {
			loading load = new loading();
			load.setVisible(true);
			Sleep(2000);
			load.setVisible(false);
			load.dispose();
			new MainFrame().setVisible(true);
		}
	}
}
