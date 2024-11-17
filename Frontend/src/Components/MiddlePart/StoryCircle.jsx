import { Avatar } from "@mui/material";
import React from "react";

const StoryCircle = () => {
  return (
    <div>
      <div className="flex flex-col items-center mr-4 cursor-pointer">
        <Avatar
          sx={{ width: "5rem", height: "5rem" }}
          src="https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg"
        ></Avatar>
        <p>Vallabhpatil777</p>
      </div>
    </div>
  );
};

export default StoryCircle;
