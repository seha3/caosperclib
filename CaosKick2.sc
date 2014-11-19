//written by @joseCao5
//sept_2_2013
//Part of CaosPercLib 1.0
//rough kick
CaosKick2 {
	*ar {|modFreq= 1, modbw= 0.1, bw= 0.1, freq1= 60, freq2= 62, lowcutfreq= 50, att= 0.01, rel= 0.5, gate= 1, amp= 0.5|
		var kick,env;
   	     		kick=RHPF.ar( 
						 Pulse.ar(
						     	Pulse.ar(modFreq,modbw,freq1,freq2),
						 bw,amp),
        		    lowcutfreq,0.5);
        		kick=CompanderD.ar(kick,0.6,0.59,0.8);
        		env=EnvGen.ar(Env.perc(att,rel),gate,doneAction:2);
    		^Pan2.ar(kick*env,[-1,0.98]);
		}
	}
