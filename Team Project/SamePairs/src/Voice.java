import com.sun.speech.freetts.VoiceManager;


public class Voice {
	//String voiceName = "kevin16";
	VoiceManager freeVM;
	com.sun.speech.freetts.Voice voice;
	public Voice(String words) {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    freeVM = VoiceManager.getInstance();
	    voice = VoiceManager.getInstance().getVoice("kevin16");
	    if (voice != null) {
	        voice.allocate();//Allocating Voice
	    }

	    try {
	        voice.setRate(190);//Setting the rate of the voice
	        voice.setPitch(150);//Setting the Pitch of the voice
	        voice.setVolume(3);//Setting the volume of the voice
	        SpeakText(words);// Calling speak() method


	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }



	}

	public void SpeakText(String words) {
	    voice.speak(words);
	}
}