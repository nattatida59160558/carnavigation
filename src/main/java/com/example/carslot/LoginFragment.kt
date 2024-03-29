package com.example.carslot


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.carslot.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {
    private var username:String=""
    private var password:String=""
    private var boo:Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login,container,false)
            binding.apply {
                show.visibility = View.GONE
                invalidateAll()
            }
        boo=false
        binding.apply{
            inputusername.text.clear()
            inputpassword.text.clear()
            invalidateAll()
        }


        binding.loginbtn.setOnClickListener { view ->
            binding.apply{
                username = inputusername.text.toString()
                password = inputpassword.text.toString()
                invalidateAll()
            }
            print(username+password)
            if(username=="username"&&password=="password"){
                boo=true

            }
            else{
                binding.apply {
                    show.visibility = View.VISIBLE
                    invalidateAll()
                }
            }
            if(boo==true){
                boo==false
                view.findNavController().navigate(R.id.action_loginFragment_to_carFragment)
            }

        }
        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())||super.onOptionsItemSelected(item)
    }


}
