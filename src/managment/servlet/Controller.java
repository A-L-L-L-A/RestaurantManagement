package managment.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import management.dao.data.ClientDao;
import management.dao.data.DishDao;
import management.data.Command;
import management.entities.Client;
import management.entities.Dish;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Controller.class);
    private static String theLocale="ru_RU";
    private static Client client;
    private static List<Dish> orderedDishes = new ArrayList<Dish>(); 
    @Resource(name="jdbc/restaurantmanagement")
	public static DataSource dataSource;
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		BasicConfigurator.configure(); 
	}
    
    
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Logic(request,response);
			logger.debug("doGet handled");
		}catch(Exception e) {
			logger.error("doGet don't handled",e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private final void Logic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		ClientDao clientDao = new ClientDao();
		DishDao dishDao = new DishDao();
		List<Dish> dishList = dishDao.getDishes();
		switch(command) {
		case Command.basePage:
			break;
		case Command.deleteClient:
			clientDao.DeleteClient(request);
			command= Command.basePage;
			break;
		case Command.clientInfo:
			Client lookableClient = clientDao.GetClient(request);
			request.setAttribute("lookableClient", lookableClient);
			break;
		case Command.clientsManagement:
			List<Client> clientList = clientDao.getClients();
			request.setAttribute("clientList", clientList);
			break;
		case Command.updateClient:
			clientDao.UpdateClient(request, Integer.parseInt(request.getParameter("lookableId")));
			command = Command.basePage;
			break;
		case Command.menuPage:
			dishList = dishDao.getDishes();
			request.setAttribute("dishList", dishList);
			request.setAttribute("orderedDishes", orderedDishes);
			break;
		case Command.orderPage:
			break;
		case Command.paymentPage:
			break;
		case Command.signInPage:
			break;
		case Command.signUpPage:
			break;
		case Command.addToCart:
			orderedDishes.add(dishDao.GetDish(request));
			dishList = dishDao.getDishes();
			request.setAttribute("dishList", dishList);
			request.setAttribute("orderedDishes", orderedDishes);
			command= Command.menuPage;
			break;
		case Command.changeLang:
			theLocale = request.getParameter("theLocale");
			command = Command.basePage;
			logger.debug("language changed");
			break;
		case Command.signIn:
			if (clientDao.CheckClient(request)) {
				client = clientDao.GetClient(request);
			}
			command = Command.basePage;
			break;
		case Command.signUp:
			clientDao.AddClient(request);
			client = clientDao.GetClient(request);
			command = Command.basePage;
			break;
		case Command.exit:
			client= null;
			orderedDishes.clear();
			command = Command.basePage;
			break;
		default:
			command = Command.basePage;
			break;
		}
		request.setAttribute("curClient", client);
		request.setAttribute("theLocale", theLocale);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/"+command+".jsp");
		rd.forward(request, response);
	}

}
