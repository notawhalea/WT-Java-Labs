package main.code.com.controller.command.impl.transition;

import main.code.com.controller.command.Command;
import main.code.com.controller.command.CommandResult;
import main.code.com.controller.command.CommandResultType;
import main.code.com.controller.context.RequestContext;
import main.code.com.controller.context.RequestContextHelper;
import main.code.com.entity.Apartment;
import main.code.com.entity.User;
import main.code.com.entity.UserOrder;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.ServiceFactory;
import main.code.com.service.description.ApartmentService;
import main.code.com.service.description.UserOrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToMyOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/myOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String APARTMENTS = "apartments";
    private static final String USER = "user";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }
        try {
            UserOrderService userOrderService=ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders=userOrderService.retrieveUserOrderByUserId(user.getId());
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);
            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserId(user.getId());
            requestContext.addRequestAttribute(APARTMENTS, apartments);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
