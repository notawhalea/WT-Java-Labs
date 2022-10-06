package main.code.com.controller.command.impl;

import main.code.com.controller.command.Command;
import main.code.com.controller.command.CommandResult;
import main.code.com.controller.command.CommandResultType;
import main.code.com.controller.context.RequestContext;
import main.code.com.controller.context.RequestContextHelper;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.ServiceFactory;
import main.code.com.service.description.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LogUpCommand implements Command {
    private static final String LOG_UP_PAGE = "WEB-INF/view/logup.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String EMAIL = "email";
    private static final String PASSWORD_FIRST = "password-first";
    private static final String PASSWORD_SECOND = "password-second";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String OK = "ok";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        String message = ERROR;

        Optional<String> email = Optional.ofNullable(requestContext.getRequestParameter(EMAIL));
        Optional<String> passwordFirst = Optional.ofNullable(requestContext.getRequestParameter(PASSWORD_FIRST));
        Optional<String> passwordSecond = Optional.ofNullable(requestContext.getRequestParameter(PASSWORD_SECOND));
        Optional<String> name = Optional.ofNullable(requestContext.getRequestParameter(NAME));
        Optional<String> surname = Optional.ofNullable(requestContext.getRequestParameter(SURNAME));
        Optional<String> phone = Optional.ofNullable(requestContext.getRequestParameter(PHONE));

        try {
            if (email.isPresent() && passwordFirst.isPresent() && passwordSecond.isPresent() &&
                    name.isPresent() && surname.isPresent() && phone.isPresent()) {
                if (passwordFirst.get().equals(passwordSecond.get())) {
                    UserService userService = ServiceFactory.getInstance().getUserService();
                    Object DigestUtils = new Object();
                    boolean result = userService.register(name.get(), surname.get(), email.get(), phone.get(), String.valueOf(DigestUtils.equals(passwordFirst.get())));
                    if (result) message = OK;
                }
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        requestContext.addRequestAttribute(MESSAGE, message);
        helper.updateRequest(requestContext);
        return new CommandResult(LOG_UP_PAGE, CommandResultType.FORWARD);
    }
}
