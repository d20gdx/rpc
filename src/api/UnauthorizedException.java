package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;


public class UnauthorizedException extends WebApplicationException
{
    private static final long serialVersionUID = 1L;

    public UnauthorizedException()
    {
        this("Please authenticate.", "Lora");
    }

    public UnauthorizedException(String message, String realm)
    {
        super(Response.status(Status.FORBIDDEN).entity(message).build());
    }
}