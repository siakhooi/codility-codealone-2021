# Codility Challenge: Code Alone

## ABSwaps

- Difficulty: Hard
- Calculate the minimum required number of swaps of neighbouring letters in a string built from the letters 'a' and 'b', after which the string would contain both "aaa" and "bbb" as substrings.
- <https://app.codility.com/programmers/challenges/codealone_2021/>
- <task-url>

## Versions

- Result
  - `Good`: Correctness 100%, Performance 100%.
  - `OK`: Correctness 100%, Performance <100%.
  - `Fail`: Correctness <100%, Performance <100%.
- File naming convention
  - Code `A`: `CodeAlone2021A.java`
  - etc

### Gold Award

| File | Description    | Complexity | Result | Report                                                                            |
| ---- | -------------- | ---------- | ------ | --------------------------------------------------------------------------------- |
| `C1` | Analysis Table | `O(N)`     | `Good` | [U5TV62](https://app.codility.com/cert/view/certU5TV62-AU72H98GBPZAWGPH/details/) |

### Silver Awards

| File | Description | Complexity          | Result | Report                                                                            |
| ---- | ----------- | ------------------- | ------ | --------------------------------------------------------------------------------- |
| `A1` | Array       | `O(N)` or `O(N**4)` | `OK`   | [NR8E2J](https://app.codility.com/cert/view/certNR8E2J-SP7V36NHRAA243UV/details/) |
| `A2` | Array       | `O(N)` or `O(N**4)` | `OK`   | [DMVG4N](https://app.codility.com/cert/view/certDMVG4N-X84ARZP4J26GBN2W/details/) |
| `B1` | Tree        | `O(N)` or `O(N**4)` | `OK`   | [5F6H9D](https://app.codility.com/cert/view/cert5F6H9D-SR4ZG28ET7AS5FNH/details/) |
| `B2` | Tree        | `O(N)` or `O(N**4)` | `OK`   | [DJSTY5](https://app.codility.com/cert/view/certDJSTY5-FMGVN2B9YGB8ZWS3/details/) |
| `B4` | Tree        | `O(N)` or `O(N**4)` | `OK`   | [JR3QRR](https://app.codility.com/cert/view/certJR3QRR-J66R55FM7ESUC6K4/details/) |
| `B5` | Tree/Array  | `O(N)` or `O(N**4)` | `OK`   | [K4VHV8](https://app.codility.com/cert/view/certK4VHV8-4ZB4KZ9SCANT6VDU/details/) |
| `B6` | Tree/Array  | `O(N)` or `O(N**4)` | `OK`   | [9XCUNY](https://app.codility.com/cert/view/cert9XCUNY-22VA78U3FYF4XX7T/details/) |

- `B3` was incomplete and has been deleted.
- `B4` has a bug, failed this scenario: `(abaab)*`, expected 3 but was 2.
