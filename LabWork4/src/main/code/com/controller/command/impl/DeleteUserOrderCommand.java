package main.code.com.controller.command.impl;

import main.code.com.controller.command.Command;
import main.code.com.controller.command.CommandResult;
import main.code.com.controller.command.CommandResultType;
import main.code.com.controller.context.RequestContext;
import main.code.com.controller.context.RequestContextHelper;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.ServiceFactory;
import main.code.com.service.description.UserOrderService;

import javax.servlet.http.HttpServletResponse;

public class DeleteUserOrderCommand implements Command {
    private static final String PAGE = "command=viewOrders";
    private static final String USER_ORDER_ID = "userOrderId";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CANCELED = "canceled";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            int userOrderId = Integer.parseInt(requestContext.getRequestParameter(USER_ORDER_ID));
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            userOrderService.updateStatusAtUserOrderById(userOrderId, CANCELED);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
