package org.test.newtonx.CRUDOperation.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.test.newtonx.CRUDOperation.DAO.UserDAO;
import org.test.newtonx.CRUDOperation.Exception.DataNotFoundException;
import org.test.newtonx.CRUDOperation.model.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {

	UserDAO userDao = new UserDAO();

	@GET
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@POST
	public Response addUser(User user,@Context UriInfo uriInfo) {
		User newUser = userDao.addUser(user);
		String newId = String.valueOf(newUser.getUser_Id());
		URI uri  = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newUser).build();
	}

	@GET
	@Path("/{user_Id}")
	public User getUser(@PathParam("user_Id") int user_Id) {
		User user =  userDao.findUserById(user_Id);
		if(user == null){
			throw new DataNotFoundException("Message With Id" + " " +user_Id+ " " + "Not Found");
		}
		return user;
	}

	@PUT
	@Path("/{user_Id}")
	public User updateUser(@PathParam("user_Id") int user_Id, User user) {
		user.setUser_Id(user_Id);
		return userDao.updateUser(user);
	}

	@DELETE
	@Path("/{user_Id}")
	public void deleteUser(@PathParam("user_Id") int user_Id) {
		userDao.deleteUser(user_Id);
	}
}
