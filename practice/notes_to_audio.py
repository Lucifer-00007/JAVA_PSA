import os
import pyttsx3

def convert_text_to_audio(text, output_path):
    """
    Convert the given text to audio and save it to the specified output path.
    """
    try:
        engine = pyttsx3.init()  # Initialize the text-to-speech engine
        engine.setProperty('rate',130) # Set the rate of speech(Default is 200).
        
        #Setting the voice(Default is male voice, and in total we have 2 voice option(male,female)).
        female="HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_EN-US_ZIRA_11.0"
        engine.setProperty('voice',female)    

        engine.save_to_file(text, output_path)  # Save the text as audio
        engine.runAndWait()  # Convert the text to speech
    except Exception as e:
        print(f"Error converting text to audio: {e}")

def process_text_file(file_path):
    """
    Read the content of the text file at the given path and return the text.
    """
    try:
        with open(file_path, 'r') as file:
            text = file.read()  # Read the content of the text file
            return text
    except Exception as e:
        print(f"Error reading text file: {e}")
        return ""

def main():
    # Get the input path from the user
    # input_path = input("Enter the path containing text files: ").strip()
    input_path = "H:\JAVA_PSA"
    
    # Define the output folder path
    output_folder = os.path.join(input_path, 'audio_output')
    
    try:
        # Create the output folder if it doesn't exist
        if not os.path.exists(output_folder):
            os.makedirs(output_folder)
    except Exception as e:
        print(f"Error creating output folder: {e}")
        return
    
    try:
        # Create a set of existing audio filenames (without extension) in the output folder
        existing_audio_files = set([filename for filename in os.listdir(output_folder) if filename.endswith('.mp3')])

        # Loop through files in the input path
        for filename in os.listdir(input_path):
            file_path = os.path.join(input_path, filename)
            
            # Check if the file is a text file and exists
            if filename.endswith('.txt') and os.path.isfile(file_path):
                output_filename = os.path.splitext(filename)[0] + '.mp3'

                # Skip files that have already been converted
                if output_filename in existing_audio_files:
                    print(f"Skipping '{filename}', already processed.")
                else:
                    output_path = os.path.join(output_folder, output_filename)
                    
                    text = process_text_file(file_path)
                    if text:
                        convert_text_to_audio(text, output_path)
                        existing_audio_files.add(output_filename)
                        print(f"Converted '{filename}' to audio!")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()





