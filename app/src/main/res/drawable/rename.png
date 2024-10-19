import os
import glob

# List all PNG files in the directory
files = glob.glob('*.png')

# Define a prefix for the new filenames
prefix = 'entity_'

# Iterate over each file, rename it according to your needs
for i, file in enumerate(files):
    # Extract the number part from the filename (in this case, just the first character)
    num_str = str(i + 1) # Convert integer to string and add 1 because enumeration starts at 0
    
    # Construct the new filename with both prefix and number
    new_filename = f'{prefix}{num_str}.png'
    
    # Rename the file
    os.rename(file, new_filename)

# After renaming all files, you might want to check the results
print('Renaming complete. Check your directory for the renamed files.')