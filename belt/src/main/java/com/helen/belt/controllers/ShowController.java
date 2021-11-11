package com.helen.belt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.helen.belt.models.Show;
import com.helen.belt.models.TvRating;
import com.helen.belt.models.User;
import com.helen.belt.services.ShowService;
import com.helen.belt.services.TvRatingService;
import com.helen.belt.services.UserService;

@Controller
public class ShowController {
	@Autowired
	private ShowService showService;

	@Autowired
	private UserService userService;

	@Autowired
	private TvRatingService tvService;

	@GetMapping("/shows")
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("user", userService.findUserById((Long) session.getAttribute("userId")));
		model.addAttribute("allShows", this.showService.getAllShows());

		return "allShows.jsp";

	}

//get create new page
	@GetMapping("/shows/new")
	public String showNew(@ModelAttribute("show") Show show) {

		return "newShow.jsp";
	}

	// create a new show
	@PostMapping("/shows/create")
	public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result, Model viewModel,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		if (result.hasErrors()) {
			return "newShow.jsp";
		} else {
			User showCreator = userService.findUserById((Long) session.getAttribute("userId"));
			show.setShowCreator(showCreator);
			this.showService.createShow(show);
			return "redirect:/shows";
		}
	}

	// display one show
	@GetMapping("/shows/{id}")
	public String showOne(Model viewModel, @PathVariable("id") Long id, HttpSession session,@ModelAttribute("tvrating") TvRating tvrating) {
		
		viewModel.addAttribute("user", userService.findUserById((Long) session.getAttribute("userId")));
		viewModel.addAttribute("thisShow", this.showService.getOneShow(id));
		return "/details.jsp";
	}

	// leave a rating
	@PostMapping("/shows/{id}/rating")
	public String rateAShow(@Valid @ModelAttribute("tvrating") TvRating tvrating, BindingResult result,
			HttpSession session, Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("thisShow", this.showService.getOneShow(id));
		User ratingCreator = userService.findUserById((Long) session.getAttribute("userId"));
		Show theShow = this.showService.getOneShow(id);

		this.tvService.createNewRating(tvrating);
		
		showService.ratingShow(ratingCreator, theShow, tvrating);
		return "redirect:/shows/"+theShow.getId();

	}
}
