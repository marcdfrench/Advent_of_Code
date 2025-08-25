var safeCounter = 0
// getting csv file from html upload
document.getElementById('csv').addEventListener('change', function (event) {
    const file = event.target.files[0];
    if (file) {
        //file reader
        const reader = new FileReader();
        reader.onload = function (e) {
            const content = e.target.result;

            // displaying csv file on html web page through pre tag 
            document.getElementById('output').innerText = content;

            // split every new line on the csv
            const lines = content.split(`\r\n`)

            // split every new line in to an object of numbers
            const result = lines.map(line => line.split())
            for (let i = 0; i < result.length; i++) {

                // converting array of objects to array of arrays
                var report = result[i].map(str => str.split(' ').map(Number));
                for (let i = 0; i < report.length; i++) {
                    if (!checkSafe(report[i])) {
                        for (let j = 0; j < report[i].length; j++) {
                            // creating two new arrays, one unsing the numbers before j and one using the numbers after j and combining them to tempArray
                            const tempArray = [...report[i].slice(0, j), ...report[i].slice(j + 1)];
                            const result = checkSafe(tempArray);
                            if (result) {
                                break
                            }
                        }
                    }

                }
            }
            console.log(`${safeCounter} are safe`);
        };
        reader.readAsText(file);
    }
});
function checkSafe(row) {
    let direction; // direction of the slope
    for (let j = 1; j < row.length; j++) { // iterate through each number starting from index 1
        const previousNumber = row[j - 1]; // previous number
        const currentNumber = row[j]; // current number
        const difference = currentNumber - previousNumber; // difference between the current and previous number

        if (j === 1) {
            // if this is the first number, set the direction
            direction = difference > 0 ? 'up' : 'down';
        }

        // if the difference is greater than 3 or equal to 0, it's a hit
        if (Math.abs(difference) > 3 || Math.abs(difference) === 0) {
            return false;
        }

        // if the direction is up and the difference is less than 0, or the direction is down and the difference is greater than 0, it's a hit
        if ((direction === 'up' && difference < 0) || (direction === 'down' && difference > 0)) {
            return false;
        }

        // if the loop has reached the end of the array and it hasn't been hit, it's a safe
        if (j === row.length - 1) {
            safeCounter++; return true;
        }
    }
}



