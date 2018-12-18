package com.bookourshow.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Address;
import com.bookourshow.model.Booking;
import com.bookourshow.model.City;
import com.bookourshow.model.Language;
import com.bookourshow.model.Movie;
import com.bookourshow.model.MovieCategory;
import com.bookourshow.model.User;
import com.bookourshow.model.Venue;
import com.bookourshow.service.AddressService;
import com.bookourshow.service.BookingService;
import com.bookourshow.service.LanguageService;
import com.bookourshow.service.MovieCategoryService;
import com.bookourshow.service.MovieService;
import com.bookourshow.service.UserService;
import com.bookourshow.service.VenueService;
import com.bookourshow.util.ConnectionUtil;

@ComponentScan({ "com.bookourshow" })
@SessionAttributes("user")
@Controller
public class TestController {
	private UserService userService;
	private MovieService movieService;
	private MovieCategoryService movieCategoryService;
	private AddressService addressService;
	private LanguageService languageService;
	private VenueService venueService;
	private BookingService bookingservice;
	
	public void setBookingservice(BookingService bookingservice) {
		this.bookingservice = bookingservice;
	}

	@Autowired
	public void setVenueService(VenueService venueService) {
		this.venueService = venueService;
	}

	@Autowired
	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@Autowired
	public void setMovieCategoryService(MovieCategoryService movieCategoryService) {
		this.movieCategoryService = movieCategoryService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		System.out.println("HOME");
		request.getSession(true).invalidate();
		String path = "loginhr";
		if (request.getSession().getAttribute("user") == null) {

		} else {
			path = "welcome";
		}
		return path;

	}

	@PostMapping("/LoginController")
	public ModelAndView login(User user, ModelAndView modelAndView) {
		System.out.println("LOGIN DETAILS" + user);
		String path = "location";
		Connection connObj = null;
		boolean flag = false;
		List<Address> addressList = new ArrayList<Address>();
		/* List<MovieCategory> movieList=new ArrayList<MovieCategory>(); */
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			flag = userService.loginCheck(connObj, user);
			if (flag) {
				modelAndView.setViewName(path);
				addressList = addressService.fetchAllLocation();
				System.out.println(addressList);
				modelAndView.addObject("user", user);
				modelAndView.addObject("addressList", addressList);

				/*
				 * movieList=movieCategoryService.fetchAllMovie();
				 * System.out.println(movieList);
				 * System.out.println("User Logged In");
				 * modelAndView.addObject("user", user);
				 * modelAndView.addObject("movieList", movieList);
				 */
			} else {
				path = "loginhr";
				modelAndView.setViewName(path);
				modelAndView.addObject("error", "INVALID CREDENTIALS... PLEASE CHECK USERNAME OR PASSWORD");
			}
		} catch (BookOurShowException notFound) {
			// TODO Auto-generated catch block
			/* e.printStackTrace(); */
			modelAndView.addObject("error", "SOME INTERNAL DATABASE ERROR");
		} catch (SQLException e) {
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// e1.printStackTrace();
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error in closing file");
			}
		}
		return modelAndView;

	}

	@GetMapping("/register")
	public String register(@ModelAttribute User user) {
		return "signuphr";
	}

	@PostMapping("/RegistrationController")
	public ModelAndView register(User user, ModelAndView modelAndView) {
		System.out.println(user);
		boolean flag = false;
		Connection connObj = null;
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);

			flag = userService.loginCheck(connObj, user);
			modelAndView.setViewName("signuphr");
			if (flag) {
				modelAndView.addObject("existUser", "USER ALREADY EXISTS!! TRY LOGGING IN...");
			} else {
				int userId = userService.registerUser(connObj, user);
				user.setUserId(userId);
				String credential = "YOUR EMPLOYEE ID: " + userId;

				modelAndView.addObject("success", "SUCCESSFUL REGISTRATION");
				modelAndView.addObject("rem", "REMEMBER YOUR CREDENTIALS FOR FUTURE");
				modelAndView.addObject("credentials", credential);
				modelAndView.addObject("mssg", "please login to continue further");

			}
			connObj.commit();
		} catch (BookOurShowException notFound) {
			notFound.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {

				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}

		}
		return modelAndView;
	}

	@GetMapping("/loc")
	public ModelAndView loc(ModelAndView modelAndView) {
		modelAndView.setViewName("location");
		List<Address> addressList = new ArrayList<Address>();
		Connection connObj = null;
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);

			addressList = addressService.fetchAllLocation();
			System.out.println(addressList);
			modelAndView.addObject("addressList", addressList);
		} catch (BookOurShowException notFound) {
			modelAndView.addObject("error", "SOME INTERNAL DATABASE ERROR");
		} catch (SQLException e) {
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error in closing file");
			}
		}
		return modelAndView;
	}

	@GetMapping("/dispmovie")
	public ModelAndView dispmovie(ModelAndView modelAndView) {
		modelAndView.setViewName("movies");
		return modelAndView;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "loginhr";
	}

	@PostMapping("/LocationController")
	public ModelAndView location(@RequestParam int address, User user, ModelAndView modelAndView) {
		System.out.println("the city iud " + address);
		String path = "movies";
		List<MovieCategory> movieList = new ArrayList<MovieCategory>();
		try {
			modelAndView.setViewName(path);
			movieList = movieCategoryService.fetchAllMovie();
			System.out.println("movieList");
			System.out.println(movieList + " " + address);
			System.out.println("User Logged In");
			modelAndView.addObject("user", user);
			modelAndView.addObject("movieList", movieList);
			modelAndView.addObject("cityId", address);

		} catch (BookOurShowException notFound) {
			// TODO Auto-generated catch block
			/* e.printStackTrace(); */
			modelAndView.addObject("error", "SOME INTERNAL DATABASE ERROR");
		}
		return modelAndView;
	}

	@GetMapping("/dispdetail")
	public ModelAndView dispdetail(@RequestParam int movieId, @RequestParam int cityId, User user,
			ModelAndView modelAndView) {
		String path = "moviedetail";
		System.out.println("the movie id is " + movieId + " and city id " + cityId);
		List<Language> languageList = new ArrayList<Language>();
		try {
			languageList = languageService.fetchLanguageByMovieAndCity(movieId,cityId);
			
			if(languageList.size()!=0){
				System.out.println(languageList + " " + movieId + " " + cityId);
				modelAndView.setViewName(path);
				modelAndView.addObject("user", user);
				modelAndView.addObject("languageList", languageList);
				modelAndView.addObject("movieId", movieId);
				modelAndView.addObject("cityId", cityId);
			}
			else{
				modelAndView.setViewName("movies");
				List<MovieCategory> movieList = new ArrayList<MovieCategory>();
				movieList = movieCategoryService.fetchAllMovie();
				modelAndView.addObject("user", user);
				modelAndView.addObject("movieList", movieList);
				modelAndView.addObject("cityId", cityId);
				modelAndView.addObject("error","THIS MOVIE IS NOT AVAILABLE IN THIS LOCATION");
			}
		} catch (BookOurShowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	@GetMapping("/bill")
	public String bill() {
		return "bill";
	}

	@GetMapping("/dispvenue")
	public ModelAndView dispvenue(@RequestParam int movieId, @RequestParam int cityId,@RequestParam int languageId,ModelAndView modelAndView,User user)
	{
		String path="theaters";
		modelAndView.setViewName(path);
		modelAndView.addObject("user", user);
		modelAndView.addObject("cityId", cityId);
		modelAndView.addObject("languageId", languageId);
		try {
			List<Venue> venueList= venueService.fetchTheaters(languageId, cityId, movieId);
			
			if(venueList.size()!=0){
				System.out.println(venueList + " " + movieId + " " + cityId);
				modelAndView.setViewName(path);
				modelAndView.addObject("user", user);
				modelAndView.addObject("venueList", venueList);
				modelAndView.addObject("movieId", movieId);
				modelAndView.addObject("cityId", cityId);
			}
			else{
				modelAndView.setViewName("movies");
				List<MovieCategory> movieList = new ArrayList<MovieCategory>();
				movieList = movieCategoryService.fetchAllMovie();
				modelAndView.addObject("user", user);
				modelAndView.addObject("movieList", movieList);
				modelAndView.addObject("cityId", cityId);
				modelAndView.addObject("movieId", movieId);
				modelAndView.addObject("error","THIS MOVIE IS NOT AVAILABLE IN THIS LOCATION");
			}
		} catch (BookOurShowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
		
	}
	@GetMapping("/booking")
	public ModelAndView booking(@RequestParam int bookingId)
	{
	  // Booking book=bookingService. 
	}
}
